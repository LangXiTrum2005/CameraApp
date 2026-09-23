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
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.photolab.vintage.R
import com.photolab.vintage.util.AdManager
import com.photolab.vintage.util.ImageUtil
import com.photolab.vintage.util.ResourceUtil
import com.photolab.vintage.util.SharePreferenceUtil
import com.photolab.vintage.util.adapter.CameraModeAdapter
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
    private lateinit var rvMode: RecyclerView
    private lateinit var takePhoto: ImageView
    private lateinit var flashIcon: ImageView
    private lateinit var gridIcon: ImageView
    private lateinit var clockIcon: ImageView
    private lateinit var countDownTv: TextView
    private lateinit var filterHeader: View
    private lateinit var tvCategoryTitle: TextView
    private lateinit var tvCategoryCount: TextView
    private lateinit var intensiveSlider: VerticalSlider

    private lateinit var tvZoom1x: TextView
    private lateinit var tvZoom3x: TextView
    private lateinit var tvZoom10x: TextView
    private var currentZoomFactor = 1f
    private lateinit var moreOptionsMenu: View

    // Retained only for legacy click branches. Fixed tab views are no longer inflated.
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
    private lateinit var modeAdapter: CameraModeAdapter
    private lateinit var modeLayoutManager: LinearLayoutManager
    private val modeSnapHelper = PagerSnapHelper()
    private var currentExpandedTabId: Int? = null

    private var isFlashOn = false
    private var isGridVisible = false
    private var timerSeconds = 0
    private var timerToast: Toast? = null

    private enum class CameraMode(val labelRes: Int, val categoryTitleRes: Int) {
        NONE(R.string.ui_mode_none, R.string.ui_mode_original),
        FILTER(R.string.ui_mode_filter, R.string.ui_mode_filter),
        DUST(R.string.ui_mode_dust, R.string.ui_mode_dust),
        LIGHT(R.string.ui_mode_light, R.string.ui_mode_light),
        MASK(R.string.ui_mode_mask, R.string.ui_mode_mask),
        GRADIENT(R.string.ui_mode_gradient, R.string.ui_mode_gradient)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemUI()
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
        rvMode = findViewById(R.id.rvMode)
        filterHeader = findViewById(R.id.filterHeader)
        takePhoto = findViewById(R.id.takePhoto)
        flashIcon = findViewById(R.id.flashIcon)
        gridIcon = findViewById(R.id.gridIcon)
        clockIcon = findViewById(R.id.clock)
        countDownTv = findViewById(R.id.countDown)
        countDownTv.visibility = View.GONE
        intensiveSlider = findViewById(R.id.intensive)
        intensiveSlider.visibility = View.GONE

        tvCategoryTitle = findViewById(R.id.tvCategoryTitle)
        tvCategoryCount = findViewById(R.id.tvCategoryCount)

        tvZoom1x = findViewById(R.id.tvZoom1x)
        tvZoom3x = findViewById(R.id.tvZoom3x)
        tvZoom10x = findViewById(R.id.tvZoom10x)

        tvZoom1x.setOnClickListener(this)
        tvZoom3x.setOnClickListener(this)
        tvZoom10x.setOnClickListener(this)

        rvFilter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        setupCameraView()
        setupAdapters()
        setupModeRail()

        intensiveSlider.setOnProgressChangeListener(object : VerticalSlider.OnProgressChangeListener {
            override fun onProgress(progress: Float) {}

            override fun onFinish() {
                val config = currentFilterConfig ?: return
                config.intensive = (intensiveSlider.getProgress() * 100.0f).toInt()
                onFilterSelected(config)
            }
        })

        moreOptionsMenu = findViewById(R.id.moreOptionsMenu)

        takePhoto.setOnClickListener(this)
        findViewById<View>(R.id.btnMore)?.setOnClickListener(this)
        findViewById<View>(R.id.swap)?.setOnClickListener(this)
        findViewById<View>(R.id.flash)?.setOnClickListener(this)
        findViewById<View>(R.id.grid)?.setOnClickListener(this)
        findViewById<View>(R.id.timer)?.setOnClickListener(this)

        isGridVisible = SharePreferenceUtil.isGridEnabled(this)
        updateGridVisibility()

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
        mCameraView.presetCameraForward(true)
        mCameraView.setFitFullView(true)
        mCameraView.setZOrderOnTop(false)
        mCameraView.setZOrderMediaOverlay(true)
        mCameraView.presetRecordingSize(1080, 1920)
        mCameraView.setOnTouchListener { v, event ->
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                    if (moreOptionsMenu.visibility == View.VISIBLE) {
                        moreOptionsMenu.visibility = View.GONE
                    }
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
    }

    private fun setupModeRail() {
        modeLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        modeAdapter = CameraModeAdapter(CameraMode.entries.map { getString(it.labelRes) }) { position ->
            centerMode(position, true)
        }
        rvMode.layoutManager = modeLayoutManager
        rvMode.adapter = modeAdapter
        modeSnapHelper.attachToRecyclerView(rvMode)
        rvMode.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState != RecyclerView.SCROLL_STATE_IDLE) return
                val snappedView = modeSnapHelper.findSnapView(modeLayoutManager) ?: return
                val distance = modeSnapHelper.calculateDistanceToFinalSnap(modeLayoutManager, snappedView)
                if (distance != null && distance[0] != 0) {
                    recyclerView.smoothScrollBy(distance[0], 0)
                } else {
                    showMode(modeLayoutManager.getPosition(snappedView))
                }
            }
        })
        rvMode.post {
            val itemWidth = (94 * resources.displayMetrics.density).toInt()
            val sidePadding = ((rvMode.width - itemWidth) / 2).coerceAtLeast(0)
            rvMode.setPadding(sidePadding, rvMode.paddingTop, sidePadding, rvMode.paddingBottom)
            centerMode(CameraMode.NONE.ordinal, false)
        }
    }

    private fun centerMode(position: Int, smooth: Boolean) {
        if (position !in CameraMode.entries.indices) return
        val modeView = modeLayoutManager.findViewByPosition(position)
        if (modeView == null) {
            modeLayoutManager.scrollToPositionWithOffset(position, rvMode.paddingLeft)
            rvMode.post { centerMode(position, smooth) }
            return
        }
        val distance = modeSnapHelper.calculateDistanceToFinalSnap(modeLayoutManager, modeView)
        if (distance == null || distance[0] == 0) {
            showMode(position)
        } else if (smooth) {
            rvMode.smoothScrollBy(distance[0], 0)
        } else {
            rvMode.scrollBy(distance[0], 0)
            showMode(position)
        }
    }

    private fun showMode(position: Int) {
        if (position !in CameraMode.entries.indices) return
        modeAdapter.select(position)

        when (CameraMode.entries[position]) {
            CameraMode.NONE -> {
                rvFilter.visibility = View.GONE
                filterHeader.visibility = View.GONE
                currentFilterConfig = null
                initConfigs()
                filterAdapter.selectedFilterIndex = 0
                dustAdapter.selectedFilterIndex = 0
                lightAdapter.selectedFilterIndex = 0
                maskAdapter.selectedFilterIndex = 0
                gradientAdapter.selectedFilterIndex = 0
                updateCategoryHeader(CameraMode.NONE.categoryTitleRes, 0)
                intensiveSlider.visibility = View.GONE
                applyFilterToCameraView()
            }
            else -> {
                val mode = CameraMode.entries[position]
                val adapter = adapterForMode(mode)
                rvFilter.visibility = View.VISIBLE
                filterHeader.visibility = View.VISIBLE
                rvFilter.adapter = adapter
                updateCategoryHeader(mode.categoryTitleRes, adapter.itemCount)
                currentFilterConfig = adapter.filterEffects.getOrNull(adapter.selectedFilterIndex)
                updateIntensiveSliderVisibility()
            }
        }
    }

    private fun adapterForMode(mode: CameraMode): FilterAdapter = when (mode) {
        CameraMode.FILTER -> filterAdapter
        CameraMode.DUST -> dustAdapter
        CameraMode.LIGHT -> lightAdapter
        CameraMode.MASK -> maskAdapter
        CameraMode.GRADIENT -> gradientAdapter
        CameraMode.NONE -> filterAdapter
    }

    private fun updateCategoryHeader(titleRes: Int, count: Int) {
        tvCategoryTitle.setText(titleRes)
        tvCategoryCount.text = getString(R.string.ui_effect_count, count)
    }

    private fun selectCategoryTab(selectedContainer: View?) = Unit

    override fun onFilterSelected(filterConfig: FilterConfig) {
        currentFilterConfig = filterConfig
        if (filterConfig.config.isEmpty()) {
            configs[filterConfig.type] = ""
            intensiveSlider.visibility = View.GONE
        } else {
            configs[filterConfig.type] = MessageFormat.format(filterConfig.config, filterConfig.intensive)
            intensiveSlider.setProgress(filterConfig.intensive / 100.0f)
            intensiveSlider.visibility = View.GONE
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
            intensiveSlider.visibility = View.GONE
            intensiveSlider.setProgress(config.intensive / 100.0f)
        }
    }

    override fun onClick(v: View?) {
        val modePosition = when (v?.id) {
            R.id.none -> CameraMode.NONE.ordinal
            R.id.filter -> CameraMode.FILTER.ordinal
            R.id.dust -> CameraMode.DUST.ordinal
            R.id.light -> CameraMode.LIGHT.ordinal
            R.id.mask -> CameraMode.MASK.ordinal
            R.id.gradient -> CameraMode.GRADIENT.ordinal
            else -> null
        }
        if (modePosition != null) {
            centerMode(modePosition, true)
            return
        }

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
                mCameraView.postDelayed({
                    setCameraZoom(currentZoomFactor)
                    if (isFlashOn && mCameraView.isCameraBackForward) {
                        mCameraView.setFlashLightMode("torch")
                    }
                }, 300)
            }
            R.id.tvZoom1x -> setCameraZoom(1f)
            R.id.tvZoom3x -> setCameraZoom(3f)
            R.id.tvZoom10x -> setCameraZoom(10f)
            R.id.flash -> {
                isFlashOn = !isFlashOn
                flashIcon.setImageResource(if (isFlashOn) R.drawable.ic_flash_on else R.drawable.ic_flash_off)
                mCameraView.setFlashLightMode(if (isFlashOn) "torch" else "off")
            }
            R.id.grid -> {
                isGridVisible = !isGridVisible
                SharePreferenceUtil.setGridEnabled(this, isGridVisible)
                updateGridVisibility()
            }
            R.id.timer -> {
                timerSeconds = when (timerSeconds) {
                    0 -> 3
                    3 -> 5
                    5 -> 9
                    else -> 0
                }
                val iconRes = when (timerSeconds) {
                    3 -> R.drawable.ic_circle_three
                    5 -> R.drawable.ic_circle_five
                    9 -> R.drawable.ic_circle_nine
                    else -> R.drawable.ic_clock
                }
                clockIcon.setImageResource(iconRes)

                timerToast?.cancel()
                val message = if (timerSeconds > 0) "Timer: ${timerSeconds}s" else "Timer Off"
                timerToast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
                timerToast?.show()
            }
            R.id.btnMore -> {
                val isVisible = moreOptionsMenu.visibility == View.VISIBLE
                moreOptionsMenu.visibility = if (isVisible) View.GONE else View.VISIBLE
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
                updateCategoryHeader(R.string.ui_mode_original, 0)
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
                    updateCategoryHeader(R.string.ui_mode_filter, filterAdapter.itemCount)
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
                    updateCategoryHeader(R.string.ui_mode_dust, dustAdapter.itemCount)
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
                    updateCategoryHeader(R.string.ui_mode_light, lightAdapter.itemCount)
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
                    updateCategoryHeader(R.string.ui_mode_mask, maskAdapter.itemCount)
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
                    updateCategoryHeader(R.string.ui_mode_gradient, gradientAdapter.itemCount)
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
            val isMirror = SharePreferenceUtil.isMirrorFrontCameraEnabled(this)
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
            }, null, "", 1.0f, isMirror)
        } catch (e: Exception) {
            takePhoto.isEnabled = true
            Log.e(TAG, "takePicture failed", e)
            Toast.makeText(this, "Camera error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
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
        mCameraView.onResume()
        applyFilterToCameraView()
        isGridVisible = SharePreferenceUtil.isGridEnabled(this)
        updateGridVisibility()
    }

    private fun updateGridVisibility() {
        val visibility = if (isGridVisible) View.VISIBLE else View.GONE
        gridIcon.setImageResource(if (isGridVisible) R.drawable.ic_grid else R.drawable.ic_grid_off)
        findViewById<View>(R.id.line1)?.visibility = visibility
        findViewById<View>(R.id.line2)?.visibility = visibility
        findViewById<View>(R.id.line3)?.visibility = visibility
        findViewById<View>(R.id.line4)?.visibility = visibility
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI()
        }
    }

    override fun onPause() {
        super.onPause()
        CameraInstance.getInstance().stopCamera()
        mCameraView.release(null)
        mCameraView.onPause()
    }

    private fun setCameraZoom(zoomFactor: Float) {
        currentZoomFactor = zoomFactor
        updateZoomUi(zoomFactor)

        try {
            val cameraInstance = CameraInstance.getInstance()
            val params = cameraInstance.params ?: return
            if (params.isZoomSupported) {
                val maxZoom = params.maxZoom
                val zoomRatios = params.zoomRatios ?: return
                val targetRatio = (zoomFactor * 100).toInt()

                var closestIndex = 0
                var minDiff = Int.MAX_VALUE
                for (i in 0..maxZoom) {
                    if (i < zoomRatios.size) {
                        val diff = Math.abs(zoomRatios[i] - targetRatio)
                        if (diff < minDiff) {
                            minDiff = diff
                            closestIndex = i
                        }
                    }
                }
                params.zoom = closestIndex
                cameraInstance.setParams(params)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun updateZoomUi(zoomFactor: Float) {
        val activeColor = androidx.core.content.ContextCompat.getColor(this, R.color.camera_accent)
        val mutedColor = androidx.core.content.ContextCompat.getColor(this, R.color.camera_text_muted)

        tvZoom1x.setTextColor(if (zoomFactor == 1f) activeColor else mutedColor)
        tvZoom3x.setTextColor(if (zoomFactor == 3f) activeColor else mutedColor)
        tvZoom10x.setTextColor(if (zoomFactor == 10f) activeColor else mutedColor)
    }

    companion object {
        private const val TAG = "CameraActivity"
    }
}
