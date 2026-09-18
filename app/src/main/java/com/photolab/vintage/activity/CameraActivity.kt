package com.photolab.vintage.activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.photolab.vintage.R
import com.photolab.vintage.util.AdManager
import com.photolab.vintage.util.ImageUtil
import com.photolab.vintage.util.ResourceUtil
import com.photolab.vintage.util.adapter.FilterAdapter
import com.photolab.vintage.util.bean.FilterConfig
import com.photolab.vintage.util.picker.PhotoPicker
import com.photolab.vintage.view.VerticalSlider
import org.wysaid.camera.CameraInstance
import org.wysaid.nativePort.CGENativeLibrary
import org.wysaid.view.CameraGLSurfaceView
import org.wysaid.view.CameraRecordGLSurfaceView
import java.text.MessageFormat
import java.util.LinkedHashMap

class CameraActivity : AppCompatActivity(), FilterAdapter.FilterListener, View.OnClickListener {

    private lateinit var mCameraView: CameraRecordGLSurfaceView
    private lateinit var cameraLayout: View
    private lateinit var focusView: ImageView
    private lateinit var rvFilter: RecyclerView
    private lateinit var takePhoto: ImageView
    private lateinit var flashIcon: ImageView
    private lateinit var countDownTv: TextView
    private lateinit var filterHeader: View
    private lateinit var tvCategoryTitle: TextView
    private lateinit var tvCategoryCount: TextView
    private lateinit var intensiveSlider: VerticalSlider
    private lateinit var ratioValue: TextView

    private lateinit var noneContainer: View
    private lateinit var filterContainer: View
    private lateinit var dustContainer: View
    private lateinit var lightContainer: View
    private lateinit var maskContainer: View
    private lateinit var gradientContainer: View

    private lateinit var filterAdapter: FilterAdapter
    private lateinit var dustAdapter: FilterAdapter
    private lateinit var lightAdapter: FilterAdapter
    private lateinit var maskAdapter: FilterAdapter
    private lateinit var gradientAdapter: FilterAdapter

    private var currentFilterConfig: FilterConfig? = null
    private val configs = LinkedHashMap<Int, String>()
    private var currentExpandedTabId: Int? = null

    private var isFlashOn = false
    private var isGridVisible = true
    private var timerSeconds = 0

    data class CameraRatio(val label: String, val width: Int, val height: Int)
    private val ratioList = listOf(
        CameraRatio("3:4", 1080, 1440),
        CameraRatio("4:5", 1080, 1350),
        CameraRatio("1:1", 1080, 1080)
    )
    private var currentRatioIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = 1280
        setContentView(R.layout.camera_layout)

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

        initConfigs()

        mCameraView = findViewById(R.id.myGLSurfaceView)
        cameraLayout = findViewById(R.id.cameraView)
        focusView = findViewById(R.id.focus)
        focusView.visibility = View.GONE
        rvFilter = findViewById(R.id.rvFilter)
        filterHeader = findViewById(R.id.filterHeader)
        takePhoto = findViewById(R.id.takePhoto)
        flashIcon = findViewById(R.id.flashIcon)
        countDownTv = findViewById(R.id.countDown)
        countDownTv.visibility = View.GONE
        intensiveSlider = findViewById(R.id.intensive)
        intensiveSlider.visibility = View.GONE
        ratioValue = findViewById(R.id.ratioValue)

        tvCategoryTitle = findViewById(R.id.tvCategoryTitle)
        tvCategoryCount = findViewById(R.id.tvCategoryCount)

        noneContainer = findViewById(R.id.none_container)
        filterContainer = findViewById(R.id.filter_container)
        dustContainer = findViewById(R.id.dust_container)
        lightContainer = findViewById(R.id.light_container)
        maskContainer = findViewById(R.id.mask_container)
        gradientContainer = findViewById(R.id.gradient_container)

        rvFilter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        setupCameraView()
        setupAdapters()

        intensiveSlider.setOnProgressChangeListener(object : VerticalSlider.OnProgressChangeListener {
            override fun onProgress(progress: Float) {}

            override fun onFinish() {
                val config = currentFilterConfig ?: return
                config.intensive = (intensiveSlider.getProgress() * 100.0f).toInt()
                onFilterSelected(config)
            }
        })

        takePhoto.setOnClickListener(this)
        findViewById<View>(R.id.swap)?.setOnClickListener(this)
        findViewById<View>(R.id.flash)?.setOnClickListener(this)
        findViewById<View>(R.id.grid)?.setOnClickListener(this)
        findViewById<View>(R.id.timer)?.setOnClickListener(this)
        findViewById<View>(R.id.ratio)?.setOnClickListener(this)

        findViewById<View>(R.id.none)?.setOnClickListener(this)
        findViewById<View>(R.id.filter)?.setOnClickListener(this)
        findViewById<View>(R.id.dust)?.setOnClickListener(this)
        findViewById<View>(R.id.light)?.setOnClickListener(this)
        findViewById<View>(R.id.mask)?.setOnClickListener(this)
        findViewById<View>(R.id.gradient)?.setOnClickListener(this)

        findViewById<View>(R.id.gallery)?.setOnClickListener {
            PhotoPicker.builder().start(this)
        }

        findViewById<View>(R.id.settings)?.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun initConfigs() {
        configs[0] = ""
        configs[1] = ""
        configs[2] = ""
        configs[3] = ""
        configs[4] = ""
    }

    private fun setupCameraView() {
        val params = cameraLayout.layoutParams as? ViewGroup.MarginLayoutParams
        if (params != null) {
            params.height = ViewGroup.LayoutParams.MATCH_PARENT
            cameraLayout.layoutParams = params
        }
        mCameraView.presetCameraForward(false)
        mCameraView.setFitFullView(true)
        mCameraView.setZOrderOnTop(false)
        mCameraView.setZOrderMediaOverlay(true)
        mCameraView.presetRecordingSize(1080, 1920)
        mCameraView.setOnTouchListener { v, event ->
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                    focusView.visibility = View.VISIBLE
                    val focusWidth = if (focusView.width > 0) focusView.width else 100
                    val focusHeight = if (focusView.height > 0) focusView.height else 100
                    focusView.x = event.x - focusWidth / 2f
                    focusView.y = event.y - focusHeight / 2f

                    if (event.actionMasked == MotionEvent.ACTION_DOWN && v.width > 0 && v.height > 0) {
                        mCameraView.focusAtPoint(event.x / v.width, event.y / v.height, null)
                    }
                    true
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    focusView.visibility = View.GONE
                    v.performClick()
                    true
                }
                else -> false
            }
        }
        updateCameraRatio(0)
    }

    private fun updateCameraRatio(index: Int) {
        currentRatioIndex = index % ratioList.size
        val ratio = ratioList[currentRatioIndex]
        ratioValue.text = ratio.label
        mCameraView.setPictureSize(ratio.width, ratio.height, true)
    }

    private fun setupAdapters() {
        val filterList = ResourceUtil.getFilterConfig()
        val dustList = ResourceUtil.getDustConfig()
        val lightList = ResourceUtil.getLightConfig()
        val maskList = ResourceUtil.getMaskConfig()
        val gradientList = ResourceUtil.getGradientConfig()

        filterAdapter = FilterAdapter(this, this, filterList)
        dustAdapter = FilterAdapter(this, this, dustList)
        lightAdapter = FilterAdapter(this, this, lightList)
        maskAdapter = FilterAdapter(this, this, maskList)
        gradientAdapter = FilterAdapter(this, this, gradientList)

        rvFilter.adapter = filterAdapter
        rvFilter.visibility = View.GONE
        filterHeader.visibility = View.GONE
        selectCategoryTab(null)
        currentExpandedTabId = null
    }

    private fun updateCategoryHeader(title: String, count: Int) {
        tvCategoryTitle.text = title
        tvCategoryCount.text = "$count hiệu ứng"
    }

    private fun selectCategoryTab(selectedContainer: View?) {
        noneContainer.background = null
        filterContainer.background = null
        dustContainer.background = null
        lightContainer.background = null
        maskContainer.background = null
        gradientContainer.background = null

        selectedContainer?.setBackgroundResource(R.drawable.bg_tab_selected)
    }

    override fun onFilterSelected(filterConfig: FilterConfig) {
        currentFilterConfig = filterConfig
        if (filterConfig.config.isEmpty()) {
            configs[filterConfig.type] = ""
            intensiveSlider.visibility = View.GONE
        } else {
            configs[filterConfig.type] = MessageFormat.format(filterConfig.config, filterConfig.intensive)
            intensiveSlider.setProgress(filterConfig.intensive / 100.0f)
            intensiveSlider.visibility = View.VISIBLE
        }
        applyFilterToCameraView()
    }

    private fun applyFilterToCameraView() {
        mCameraView.queueEvent {
            val builder = StringBuilder()
            for (value in configs.values) {
                if (value.isNotEmpty()) {
                    builder.append(value).append(" ")
                }
            }
            mCameraView.setFilterWithConfig(builder.toString().trim())
        }
    }

    private fun updateIntensiveSliderVisibility() {
        val config = currentFilterConfig
        if (config == null || config.config.isEmpty() || config.type == 0) {
            intensiveSlider.visibility = View.GONE
        } else {
            intensiveSlider.visibility = View.VISIBLE
            intensiveSlider.setProgress(config.intensive / 100.0f)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.takePhoto -> {
                if (timerSeconds > 0) {
                    startTimerAndCapture()
                } else {
                    capturePhoto()
                }
            }
            R.id.swap -> {
                mCameraView.switchCamera()
            }
            R.id.flash -> {
                isFlashOn = !isFlashOn
                flashIcon.setImageResource(if (isFlashOn) R.drawable.ic_flash_on else R.drawable.ic_flash_off)
                mCameraView.setFlashLightMode(if (isFlashOn) "on" else "off")
            }
            R.id.grid -> {
                isGridVisible = !isGridVisible
                val visibility = if (isGridVisible) View.VISIBLE else View.GONE
                findViewById<View>(R.id.line1)?.visibility = visibility
                findViewById<View>(R.id.line2)?.visibility = visibility
                findViewById<View>(R.id.line3)?.visibility = visibility
                findViewById<View>(R.id.line4)?.visibility = visibility
            }
            R.id.timer -> {
                timerSeconds = when (timerSeconds) {
                    0 -> 3
                    3 -> 5
                    else -> 0
                }
                if (timerSeconds > 0) {
                    Toast.makeText(this, "Timer: ${timerSeconds}s", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Timer Off", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.ratio -> {
                updateCameraRatio(currentRatioIndex + 1)
            }
            R.id.none -> {
                currentExpandedTabId = null
                rvFilter.visibility = View.GONE
                filterHeader.visibility = View.GONE
                currentFilterConfig = null
                initConfigs()
                filterAdapter.selectedFilterIndex = 0
                dustAdapter.selectedFilterIndex = 0
                lightAdapter.selectedFilterIndex = 0
                maskAdapter.selectedFilterIndex = 0
                gradientAdapter.selectedFilterIndex = 0
                selectCategoryTab(noneContainer)
                updateCategoryHeader("NGUYÊN BẢN", 0)
                intensiveSlider.visibility = View.GONE
                applyFilterToCameraView()
            }
            R.id.filter -> {
                if (currentExpandedTabId == R.id.filter) {
                    currentExpandedTabId = null
                    rvFilter.visibility = View.GONE
                    filterHeader.visibility = View.GONE
                    selectCategoryTab(null)
                    intensiveSlider.visibility = View.GONE
                } else {
                    currentExpandedTabId = R.id.filter
                    rvFilter.visibility = View.VISIBLE
                    filterHeader.visibility = View.VISIBLE
                    rvFilter.adapter = filterAdapter
                    selectCategoryTab(filterContainer)
                    updateCategoryHeader("BỘ LỌC", filterAdapter.itemCount)
                    currentFilterConfig = filterAdapter.filterEffects.getOrNull(filterAdapter.selectedFilterIndex)
                    updateIntensiveSliderVisibility()
                }
            }
            R.id.dust -> {
                if (currentExpandedTabId == R.id.dust) {
                    currentExpandedTabId = null
                    rvFilter.visibility = View.GONE
                    filterHeader.visibility = View.GONE
                    selectCategoryTab(null)
                    intensiveSlider.visibility = View.GONE
                } else {
                    currentExpandedTabId = R.id.dust
                    rvFilter.visibility = View.VISIBLE
                    filterHeader.visibility = View.VISIBLE
                    rvFilter.adapter = dustAdapter
                    selectCategoryTab(dustContainer)
                    updateCategoryHeader("BỤI PHIM", dustAdapter.itemCount)
                    currentFilterConfig = dustAdapter.filterEffects.getOrNull(dustAdapter.selectedFilterIndex)
                    updateIntensiveSliderVisibility()
                }
            }
            R.id.light -> {
                if (currentExpandedTabId == R.id.light) {
                    currentExpandedTabId = null
                    rvFilter.visibility = View.GONE
                    filterHeader.visibility = View.GONE
                    selectCategoryTab(null)
                    intensiveSlider.visibility = View.GONE
                } else {
                    currentExpandedTabId = R.id.light
                    rvFilter.visibility = View.VISIBLE
                    filterHeader.visibility = View.VISIBLE
                    rvFilter.adapter = lightAdapter
                    selectCategoryTab(lightContainer)
                    updateCategoryHeader("ÁNH SÁNG", lightAdapter.itemCount)
                    currentFilterConfig = lightAdapter.filterEffects.getOrNull(lightAdapter.selectedFilterIndex)
                    updateIntensiveSliderVisibility()
                }
            }
            R.id.mask -> {
                if (currentExpandedTabId == R.id.mask) {
                    currentExpandedTabId = null
                    rvFilter.visibility = View.GONE
                    filterHeader.visibility = View.GONE
                    selectCategoryTab(null)
                    intensiveSlider.visibility = View.GONE
                } else {
                    currentExpandedTabId = R.id.mask
                    rvFilter.visibility = View.VISIBLE
                    filterHeader.visibility = View.VISIBLE
                    rvFilter.adapter = maskAdapter
                    selectCategoryTab(maskContainer)
                    updateCategoryHeader("MẶT NẠ", maskAdapter.itemCount)
                    currentFilterConfig = maskAdapter.filterEffects.getOrNull(maskAdapter.selectedFilterIndex)
                    updateIntensiveSliderVisibility()
                }
            }
            R.id.gradient -> {
                if (currentExpandedTabId == R.id.gradient) {
                    currentExpandedTabId = null
                    rvFilter.visibility = View.GONE
                    filterHeader.visibility = View.GONE
                    selectCategoryTab(null)
                    intensiveSlider.visibility = View.GONE
                } else {
                    currentExpandedTabId = R.id.gradient
                    rvFilter.visibility = View.VISIBLE
                    filterHeader.visibility = View.VISIBLE
                    rvFilter.adapter = gradientAdapter
                    selectCategoryTab(gradientContainer)
                    updateCategoryHeader("CHUYỂN MÀU", gradientAdapter.itemCount)
                    currentFilterConfig = gradientAdapter.filterEffects.getOrNull(gradientAdapter.selectedFilterIndex)
                    updateIntensiveSliderVisibility()
                }
            }
        }
    }

    private fun startTimerAndCapture() {
        takePhoto.isEnabled = false
        countDownTv.visibility = View.VISIBLE
        object : CountDownTimer((timerSeconds * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secLeft = (millisUntilFinished / 1000 + 1).toInt()
                countDownTv.text = secLeft.toString()
            }

            override fun onFinish() {
                countDownTv.visibility = View.GONE
                takePhoto.isEnabled = true
                capturePhoto()
            }
        }.start()
    }

    private fun capturePhoto() {
        takePhoto.isEnabled = false
        try {
            mCameraView.takePicture(object : CameraGLSurfaceView.TakePictureCallback {
                override fun takePictureOK(bitmap: Bitmap?) {
                    takePhoto.post { takePhoto.isEnabled = true }
                    if (bitmap != null) {
                        val savedPath = ImageUtil.saveBitmapInCache(this@CameraActivity, bitmap)
                        bitmap.recycle()

                        val intent = Intent(this@CameraActivity, EditPhotoActivity::class.java).apply {
                            val fIdx = filterAdapter.selectedFilterIndex
                            val dIdx = dustAdapter.selectedFilterIndex
                            val lIdx = lightAdapter.selectedFilterIndex
                            val mIdx = maskAdapter.selectedFilterIndex
                            val gIdx = gradientAdapter.selectedFilterIndex

                            putExtra("0", fIdx)
                            putExtra("0_intensive", filterAdapter.filterEffects.getOrNull(fIdx)?.intensive ?: 100)
                            putExtra("2", dIdx)
                            putExtra("2_intensive", dustAdapter.filterEffects.getOrNull(dIdx)?.intensive ?: 100)
                            putExtra("1", lIdx)
                            putExtra("1_intensive", lightAdapter.filterEffects.getOrNull(lIdx)?.intensive ?: 80)
                            putExtra("4", mIdx)
                            putExtra("4_intensive", maskAdapter.filterEffects.getOrNull(mIdx)?.intensive ?: 25)
                            putExtra("3", gIdx)
                            putExtra("3_intensive", gradientAdapter.filterEffects.getOrNull(gIdx)?.intensive ?: 40)
                            putExtra("path", savedPath)
                        }
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@CameraActivity, "Photo capture failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }, null, "", 1.0f, true)
        } catch (e: Exception) {
            takePhoto.isEnabled = true
            Log.e(TAG, "takePicture failed", e)
            Toast.makeText(this, "Camera error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        mCameraView.onResume()
        applyFilterToCameraView()
    }

    override fun onPause() {
        super.onPause()
        CameraInstance.getInstance().stopCamera()
        mCameraView.release(null)
        mCameraView.onPause()
    }

    companion object {
        private const val TAG = "CameraActivity"
    }
}
