package com.photolab.vintage.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Rect
import android.media.ExifInterface
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.photolab.vintage.R
import com.photolab.vintage.util.AdManager
import com.photolab.vintage.util.DateUtil
import com.photolab.vintage.util.ImageUtil
import com.photolab.vintage.util.ResourceUtil
import com.photolab.vintage.util.adapter.DateAdapter
import com.photolab.vintage.util.adapter.EditingToolsAdapter
import com.photolab.vintage.util.adapter.FilterAdapter
import com.photolab.vintage.util.bean.FilterConfig
import com.photolab.vintage.view.ToolType
import com.photolab.vintage.view.LiquidGlassCarouselEffect
import com.photolab.vintage.view.VerticalSlider
import org.wysaid.nativePort.CGENativeLibrary
import org.wysaid.view.ImageGLSurfaceView
import java.io.File
import java.text.MessageFormat
import java.util.Date

class EditPhotoActivity : AppCompatActivity(), FilterAdapter.FilterListener, DateAdapter.DateListener {

    private lateinit var rvTools: RecyclerView
    private lateinit var rvFilterView: RecyclerView
    private lateinit var glSurfaceView: ImageGLSurfaceView
    private lateinit var textSubTitle: TextView
    private lateinit var tvDateOverlay: TextView
    private lateinit var intensiveSlider: VerticalSlider

    private lateinit var dateAdapter: DateAdapter
    private var currentDatePattern: String = DateUtil.FORMAT_DEFAULT

    private var currentBitmap: Bitmap? = null
    private var currentTool: ToolType = ToolType.FILTER
    private var currentFilterConfig: FilterConfig? = null

    private lateinit var filterAdapter: FilterAdapter
    private lateinit var dustAdapter: FilterAdapter
    private lateinit var lightAdapter: FilterAdapter
    private lateinit var gradientAdapter: FilterAdapter
    private lateinit var maskAdapter: FilterAdapter

    private val configs = LinkedHashMap<Int, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI()
        setContentView(R.layout.edit_layout)

        AdManager.getInstance().loadInterstitialAd(this)

        CGENativeLibrary.setLoadImageCallback(object : CGENativeLibrary.LoadImageCallback {
            override fun loadImage(name: String?, obj: Any?): Bitmap? {
                if (name == null) return null
                return try {
                    BitmapFactory.decodeStream(assets.open(name))
                } catch (e: Exception) {
                    null
                }
            }

            override fun loadImageOK(bitmap: Bitmap?, obj: Any?) {
                bitmap?.recycle()
            }
        }, null)

        glSurfaceView = findViewById(R.id.mainImageView)
        rvTools = findViewById(R.id.rvConstraintTools)
        rvFilterView = findViewById(R.id.rvFilterView)
        textSubTitle = findViewById(R.id.textSubTitle)
        tvDateOverlay = findViewById(R.id.tvDateOverlay)
        intensiveSlider = findViewById(R.id.intensive)

        findViewById<View>(R.id.adjust)?.visibility = View.GONE

        updateDateSubtitle(currentDatePattern)

        setupPhoto()
        setupAdapters()

        intensiveSlider.setOnProgressChangeListener(object : VerticalSlider.OnProgressChangeListener {
            override fun onProgress(progress: Float) {}

            override fun onFinish() {
                val config = currentFilterConfig ?: return
                config.intensive = (intensiveSlider.getProgress() * 100.0f).toInt()
                onFilterSelected(config)
            }
        })

        findViewById<View>(R.id.save)?.setOnClickListener {
            saveEditedImage()
        }

        findViewById<View>(R.id.back)?.setOnClickListener {
            finish()
        }
    }

    private fun updateDateSubtitle(pattern: String) {
        currentDatePattern = pattern
        if (pattern.isEmpty()) {
            textSubTitle.visibility = View.GONE
            tvDateOverlay.visibility = View.GONE
        } else {
            val formattedDate = DateUtil.getDateFormat(Date(), pattern)
            textSubTitle.visibility = View.VISIBLE
            textSubTitle.text = formattedDate
            tvDateOverlay.visibility = View.VISIBLE
            tvDateOverlay.text = formattedDate
        }
    }

    private fun setupPhoto() {
        val uriStr = intent.getStringExtra("SELECTED_PHOTO") ?: intent.getStringExtra("path")
        if (uriStr != null) {
            try {
                val uri = if (uriStr.startsWith("content://") || uriStr.startsWith("file://")) {
                    Uri.parse(uriStr)
                } else {
                    Uri.fromFile(File(uriStr))
                }
                val inputStream = contentResolver.openInputStream(uri)
                val decoded = BitmapFactory.decodeStream(inputStream)
                inputStream?.close()

                if (decoded != null) {
                    currentBitmap = rotateBitmapIfRequired(decoded, uri, uriStr)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                val decoded = BitmapFactory.decodeFile(uriStr)
                if (decoded != null) {
                    val uri = Uri.fromFile(File(uriStr))
                    currentBitmap = rotateBitmapIfRequired(decoded, uri, uriStr)
                }
            }
        }

        glSurfaceView.setDisplayMode(ImageGLSurfaceView.DisplayMode.DISPLAY_ASPECT_FIT)
        glSurfaceView.setSurfaceCreatedCallback {
            currentBitmap?.let { bitmap ->
                glSurfaceView.setImageBitmap(bitmap)
                applyCurrentConfigs()
            }
        }
    }

    private fun rotateBitmapIfRequired(bitmap: Bitmap, uri: Uri, uriStr: String): Bitmap {
        var orientation = ExifInterface.ORIENTATION_UNDEFINED
        try {
            contentResolver.openInputStream(uri)?.use { stream ->
                val exif = ExifInterface(stream)
                orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (orientation == ExifInterface.ORIENTATION_UNDEFINED || orientation == ExifInterface.ORIENTATION_NORMAL) {
            if (!uriStr.startsWith("content://")) {
                try {
                    val filePath = if (uriStr.startsWith("file://")) Uri.parse(uriStr).path else uriStr
                    if (filePath != null && File(filePath).exists()) {
                        val exif = ExifInterface(filePath)
                        orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        val matrix = Matrix()
        when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> matrix.postRotate(90f)
            ExifInterface.ORIENTATION_ROTATE_180 -> matrix.postRotate(180f)
            ExifInterface.ORIENTATION_ROTATE_270 -> matrix.postRotate(270f)
            ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> matrix.postScale(-1f, 1f)
            ExifInterface.ORIENTATION_FLIP_VERTICAL -> matrix.postScale(1f, -1f)
            ExifInterface.ORIENTATION_TRANSPOSE -> {
                matrix.postRotate(90f)
                matrix.postScale(-1f, 1f)
            }
            ExifInterface.ORIENTATION_TRANSVERSE -> {
                matrix.postRotate(270f)
                matrix.postScale(-1f, 1f)
            }
            else -> return bitmap
        }

        val rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
        if (rotatedBitmap != bitmap) {
            bitmap.recycle()
        }
        return rotatedBitmap
    }

    private fun setupAdapters() {
        val filterList = ResourceUtil.getFilterConfig()
        val dustList = ResourceUtil.getDustConfig()
        val lightList = ResourceUtil.getLightConfig()
        val maskList = ResourceUtil.getMaskConfig()
        val gradientList = ResourceUtil.getGradientConfig()

        val filterIdx = intent.getIntExtra("0", 0)
        val dustIdx = intent.getIntExtra("2", 0)
        val dustIntensive = intent.getIntExtra("2_intensive", 100)
        val lightIdx = intent.getIntExtra("1", 0)
        val lightIntensive = intent.getIntExtra("1_intensive", 80)
        val maskIdx = intent.getIntExtra("4", 0)
        val maskIntensive = intent.getIntExtra("4_intensive", 25)
        val gradientIdx = intent.getIntExtra("3", 0)
        val gradientIntensive = intent.getIntExtra("3_intensive", 40)

        filterAdapter = FilterAdapter(this, this, filterList).apply { selectedFilterIndex = filterIdx }
        dustAdapter = FilterAdapter(this, this, dustList).apply { 
            selectedFilterIndex = dustIdx
            if (dustIdx in dustList.indices) dustList[dustIdx].intensive = dustIntensive 
        }
        lightAdapter = FilterAdapter(this, this, lightList).apply { 
            selectedFilterIndex = lightIdx
            if (lightIdx in lightList.indices) lightList[lightIdx].intensive = lightIntensive
        }
        gradientAdapter = FilterAdapter(this, this, gradientList).apply { 
            selectedFilterIndex = gradientIdx
            if (gradientIdx in gradientList.indices) gradientList[gradientIdx].intensive = gradientIntensive
        }
        maskAdapter = FilterAdapter(this, this, maskList).apply { 
            selectedFilterIndex = maskIdx
            if (maskIdx in maskList.indices) maskList[maskIdx].intensive = maskIntensive
        }

        dateAdapter = DateAdapter(this, this)

        if (filterIdx in filterList.indices && filterList[filterIdx].config.isNotEmpty()) {
            configs[0] = MessageFormat.format(filterList[filterIdx].config, filterList[filterIdx].intensive)
        }
        if (dustIdx in dustList.indices && dustList[dustIdx].config.isNotEmpty()) {
            configs[2] = MessageFormat.format(dustList[dustIdx].config, dustList[dustIdx].intensive)
        }
        if (lightIdx in lightList.indices && lightList[lightIdx].config.isNotEmpty()) {
            configs[1] = MessageFormat.format(lightList[lightIdx].config, lightList[lightIdx].intensive)
        }
        if (gradientIdx in gradientList.indices && gradientList[gradientIdx].config.isNotEmpty()) {
            configs[3] = MessageFormat.format(gradientList[gradientIdx].config, gradientList[gradientIdx].intensive)
        }
        if (maskIdx in maskList.indices && maskList[maskIdx].config.isNotEmpty()) {
            configs[4] = MessageFormat.format(maskList[maskIdx].config, maskList[maskIdx].intensive)
        }

        rvFilterView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvFilterView.adapter = filterAdapter

        val toolsAdapter = EditingToolsAdapter { tool ->
            currentTool = tool
            when (tool) {
                ToolType.FILTER -> {
                    rvFilterView.visibility = View.VISIBLE
                    rvFilterView.adapter = filterAdapter
                    intensiveSlider.visibility = View.GONE
                }
                ToolType.DUST -> {
                    rvFilterView.visibility = View.VISIBLE
                    rvFilterView.adapter = dustAdapter
                    intensiveSlider.visibility = View.GONE
                }
                ToolType.LIGHT -> {
                    rvFilterView.visibility = View.VISIBLE
                    rvFilterView.adapter = lightAdapter
                    intensiveSlider.visibility = View.GONE
                }
                ToolType.GRADIENT -> {
                    rvFilterView.visibility = View.VISIBLE
                    rvFilterView.adapter = gradientAdapter
                    intensiveSlider.visibility = View.GONE
                }
                ToolType.MASK -> {
                    rvFilterView.visibility = View.VISIBLE
                    rvFilterView.adapter = maskAdapter
                    intensiveSlider.visibility = View.GONE
                }
                ToolType.NONE -> {
                    rvFilterView.visibility = View.GONE
                    clearAllFilters()
                }
                ToolType.DATE -> {
                    rvFilterView.visibility = View.VISIBLE
                    rvFilterView.adapter = dateAdapter
                    intensiveSlider.visibility = View.GONE
                }
            }
        }

        rvTools.layoutManager = GridLayoutManager(this, toolsAdapter.itemCount)
        rvTools.adapter = toolsAdapter

        LiquidGlassCarouselEffect(minScale = 0.92f, edgeAlpha = 0.72f).attachTo(rvFilterView)
    }

    override fun onFilterSelected(filterConfig: FilterConfig) {
        currentFilterConfig = filterConfig
        if (filterConfig.config.isEmpty()) {
            configs.remove(filterConfig.type)
            intensiveSlider.visibility = View.GONE
        } else {
            configs[filterConfig.type] = MessageFormat.format(filterConfig.config, filterConfig.intensive)
            intensiveSlider.setProgress(filterConfig.intensive / 100.0f)
            intensiveSlider.visibility = View.GONE
        }
        applyCurrentConfigs()
    }

    override fun onDateFormatSelected(format: String) {
        updateDateSubtitle(format)
    }

    private fun clearAllFilters() {
        configs.clear()
        currentFilterConfig = null
        filterAdapter.selectedFilterIndex = 0
        dustAdapter.selectedFilterIndex = 0
        lightAdapter.selectedFilterIndex = 0
        gradientAdapter.selectedFilterIndex = 0
        maskAdapter.selectedFilterIndex = 0
        intensiveSlider.visibility = View.GONE
        applyCurrentConfigs()
    }

    private fun applyCurrentConfigs() {
        val builder = StringBuilder()
        for (value in configs.values) {
            if (value.isNotEmpty()) {
                builder.append(value).append(" ")
            }
        }
        val configStr = builder.toString().trim()
        glSurfaceView.setFilterWithConfig(configStr)
    }

    private fun saveEditedImage() {
        glSurfaceView.getResultBitmap { bitmap ->
            var bmp = bitmap ?: currentBitmap ?: return@getResultBitmap
            if (tvDateOverlay.visibility == View.VISIBLE && currentDatePattern.isNotEmpty()) {
                val dateText = tvDateOverlay.text.toString()
                if (dateText.isNotEmpty()) {
                    bmp = addDateStampToBitmap(bmp, dateText)
                }
            }
            val savedPath = ImageUtil.saveBitmap(this, bmp)
            if (savedPath != null) {
                val intent = Intent(this, SaveAndShareActivity::class.java).apply {
                    putExtra("path", savedPath)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, R.string.ui_save_failed, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addDateStampToBitmap(sourceBitmap: Bitmap, dateText: String): Bitmap {
        val resultBitmap = sourceBitmap.copy(Bitmap.Config.ARGB_8888, true)
        val canvas = Canvas(resultBitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.parseColor("#FFB300")
            textSize = resultBitmap.width * 0.045f
            typeface = ResourcesCompat.getFont(this@EditPhotoActivity, R.font.font_time)
        }
        val textBounds = Rect()
        paint.getTextBounds(dateText, 0, dateText.length, textBounds)

        val marginX = resultBitmap.width * 0.04f
        val marginY = resultBitmap.height * 0.04f
        val x = resultBitmap.width - textBounds.width() - marginX
        val y = resultBitmap.height - marginY

        canvas.drawText(dateText, x, y, paint)
        return resultBitmap
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.navigationBars())
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        )
    }

    override fun onResume() {
        super.onResume()
        hideSystemUI()
        glSurfaceView.onResume()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

    override fun onPause() {
        super.onPause()
        glSurfaceView.release()
        glSurfaceView.onPause()
    }
}

