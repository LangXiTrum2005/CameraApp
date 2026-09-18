package com.photolab.vintage.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Camera;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.photolab.vintage.R;
import com.photolab.vintage.util.CrashlyticsHelper;
import com.photolab.vintage.util.FirebaseAnalyticsHelper;
import com.photolab.vintage.util.FirebaseRealtimeHelper;
import com.photolab.vintage.util.ImageUtil;
import com.photolab.vintage.util.PerformanceHelper;
import com.photolab.vintage.util.ResourceUtil;
import com.photolab.vintage.util.SharePreferenceUtil;
import com.photolab.vintage.util.SystemUtil;
import com.photolab.vintage.util.adapter.FilterAdapter;
import com.photolab.vintage.util.bean.FilterConfig;
import com.photolab.vintage.util.picker.PhotoPicker;
import com.photolab.vintage.util.picker.utils.PermissionsUtils;
import com.photolab.vintage.view.VerticalSlider;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import org.wysaid.camera.CameraInstance;
import org.wysaid.nativePort.CGENativeLibrary;
import org.wysaid.view.CameraGLSurfaceView;
import org.wysaid.view.CameraRecordGLSurfaceView;

/* JADX INFO: loaded from: classes2.dex */
public class CameraActivity extends AppCompatActivity implements FilterAdapter.FilterListener, View.OnClickListener {
    private static final int PERMISSION_REQUEST_CODE_NOTIF = 102;
    private ConstraintLayout cameraLayout;
    private RelativeLayout cameraOverlay;
    private LinkedHashMap<Integer, String> configs;
    private TextView countDown;
    private boolean countdownSoundEnabled;
    private FilterConfig currentFilterConfig;
    private int currentMode;
    private int delta;
    private FilterAdapter dustAdapter;
    private FilterAdapter filterAdapter;
    private ImageView flashIcon;
    private ImageView focus;
    private FilterAdapter gradientAdapter;
    private KProgressHUD hud;
    private VerticalSlider intensive;
    private boolean isFlashModel;
    private boolean isGrid;
    private FilterAdapter lightAdapter;
    private List<Function> lstFunctions;
    private CameraRecordGLSurfaceView mCameraView;
    private FilterAdapter maskAdapter;
    private View paddingTop;
    private TextView ratioValue;
    private RecyclerView rvFilter;
    private ImageView takePhoto;
    private ImageView timer;
    private ToneGenerator toneGenerator;
    private LinearLayout topFunction;
    private ViewGroup viewGroup;
    private int widthScreen;
    private List<COUNT_DOWN> countDowns = new ArrayList();
    private int currentCountDown = 0;
    public CGENativeLibrary.LoadImageCallback mLoadImageCallback = new CGENativeLibrary.LoadImageCallback() { // from class: com.photolab.vintage.activity.CameraActivity.1
        @Override // org.wysaid.nativePort.CGENativeLibrary.LoadImageCallback
        public Bitmap loadImage(String str, Object obj) {
            try {
                return BitmapFactory.decodeStream(CameraActivity.this.getAssets().open(str));
            } catch (IOException unused) {
                return null;
            }
        }

        @Override // org.wysaid.nativePort.CGENativeLibrary.LoadImageCallback
        public void loadImageOK(Bitmap bitmap, Object obj) {
            bitmap.recycle();
        }
    };
    private List<RATIO> ratios = new ArrayList();

    public enum RATIO {
        R_1_1(1, 1),
        R_3_4(3, 4),
        R_4_5(4, 5);

        private int height;
        private int width;

        RATIO(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public String getName() {
            return this.width + ":" + this.height;
        }

        public float getRatio() {
            return this.height / this.width;
        }
    }

    enum COUNT_DOWN {
        NONE(0, R.drawable.ic_clock),
        THREE(3, R.drawable.ic_circle_three),
        FIVE(5, R.drawable.ic_circle_five),
        NINE(9, R.drawable.ic_circle_nine);

        private int resource;
        private int time;

        COUNT_DOWN(int i, int i2) {
            this.time = i;
            this.resource = i2;
        }

        public int getResource() {
            return this.resource;
        }

        public int getTime() {
            return this.time;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PerformanceHelper.startScreenTrace("CameraActivity");
        CrashlyticsHelper.trackScreen("CameraActivity");
        FirebaseAnalyticsHelper.trackCameraOpened(this);
        setContentView(R.layout.camera_layout);
        if (Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 102);
        }
        SharePreferenceUtil.increateCounter(getApplicationContext());
        Window window = getWindow();
        window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        initConfigs();
        this.viewGroup = (ViewGroup) findViewById(android.R.id.content);
        this.configs.put(2, MessageFormat.format(ResourceUtil.getDustConfig().get(1).getConfig(), Integer.valueOf(ResourceUtil.getDustConfig().get(1).getIntensive())));
        FilterAdapter filterAdapter = new FilterAdapter(this, this, ResourceUtil.getDustConfig());
        this.dustAdapter = filterAdapter;
        filterAdapter.setSelectedFilterIndex(1);
        this.configs.put(0, MessageFormat.format(ResourceUtil.getFilterConfig().get(1).getConfig(), Integer.valueOf(ResourceUtil.getFilterConfig().get(1).getIntensive())));
        FilterAdapter filterAdapter2 = new FilterAdapter(this, this, ResourceUtil.getFilterConfig());
        this.filterAdapter = filterAdapter2;
        filterAdapter2.setSelectedFilterIndex(1);
        this.lightAdapter = new FilterAdapter(this, this, ResourceUtil.getLightConfig());
        this.maskAdapter = new FilterAdapter(this, this, ResourceUtil.getMaskConfig());
        this.gradientAdapter = new FilterAdapter(this, this, ResourceUtil.getGradientConfig());
        this.ratios.add(RATIO.R_4_5);
        this.ratios.add(RATIO.R_3_4);
        this.ratios.add(RATIO.R_1_1);
        this.countDowns.add(COUNT_DOWN.NONE);
        this.countDowns.add(COUNT_DOWN.THREE);
        this.countDowns.add(COUNT_DOWN.FIVE);
        this.countDowns.add(COUNT_DOWN.NINE);
        this.widthScreen = point.x;
        this.delta = SystemUtil.dpToPx(getApplicationContext(), 25);
        CGENativeLibrary.setLoadImageCallback(this.mLoadImageCallback, null);
        this.hud = KProgressHUD.create(this).setStyle(KProgressHUD.Style.ANNULAR_DETERMINATE).setDimAmount(1.0f).setLabel("Processing...").setMaxProgress(100);
        this.isGrid = SharePreferenceUtil.isGridEnabled(this);
        this.countdownSoundEnabled = SharePreferenceUtil.isCountdownSoundEnabled(this);
        this.toneGenerator = new ToneGenerator(3, 80);
        VerticalSlider verticalSlider = (VerticalSlider) findViewById(R.id.intensive);
        this.intensive = verticalSlider;
        verticalSlider.setVisibility(8);
        this.intensive.setOnSliderProgressChangeListener(new VerticalSlider.OnProgressChangeListener() { // from class: com.photolab.vintage.activity.CameraActivity.2
            @Override // com.photolab.vintage.view.VerticalSlider.OnProgressChangeListener
            public void onProgress(float f) {
            }

            @Override // com.photolab.vintage.view.VerticalSlider.OnProgressChangeListener
            public void onFinish() {
                Log.e("sss", "" + CameraActivity.this.intensive.getProgress());
                if (CameraActivity.this.currentFilterConfig != null) {
                    CameraActivity.this.currentFilterConfig.setIntensive((int) (CameraActivity.this.intensive.getProgress() * 100.0f));
                    CameraActivity cameraActivity = CameraActivity.this;
                    cameraActivity.onFilterSelected(cameraActivity.currentFilterConfig);
                    return;
                }
                CameraActivity.this.intensive.setVisibility(8);
            }
        });
        this.paddingTop = findViewById(R.id.paddingTop);
        this.topFunction = (LinearLayout) findViewById(R.id.topFunction);
        this.cameraOverlay = (RelativeLayout) findViewById(R.id.cameraOverlay);
        TextView textView = (TextView) findViewById(R.id.countDown);
        this.countDown = textView;
        textView.setVisibility(8);
        this.takePhoto = (ImageView) findViewById(R.id.takePhoto);
        this.flashIcon = (ImageView) findViewById(R.id.flashIcon);
        this.ratioValue = (TextView) findViewById(R.id.ratioValue);
        this.cameraLayout = (ConstraintLayout) findViewById(R.id.cameraView);
        CameraRecordGLSurfaceView cameraRecordGLSurfaceView = (CameraRecordGLSurfaceView) findViewById(R.id.myGLSurfaceView);
        this.mCameraView = cameraRecordGLSurfaceView;
        cameraRecordGLSurfaceView.presetCameraForward(true);
        this.mCameraView.setFitFullView(true);
        this.mCameraView.setZOrderOnTop(false);
        this.mCameraView.setZOrderMediaOverlay(true);
        float f = point.y / point.x;
        int i = 1080;
        int i2 = 1920;
        int[][] iArr = {new int[]{720, 1280}, new int[]{1080, 1920}, new int[]{1080, 2160}, new int[]{1080, 2280}, new int[]{1080, 2340}, new int[]{1080, 2400}};
        float f2 = Float.MAX_VALUE;
        for (int i3 = 0; i3 < 6; i3++) {
            int[] iArr2 = iArr[i3];
            float fAbs = Math.abs((iArr2[1] / iArr2[0]) - f);
            if (fAbs < f2) {
                int i4 = iArr2[0];
                i2 = iArr2[1];
                i = i4;
                f2 = fAbs;
            }
        }
        this.mCameraView.presetRecordingSize(i, i2);
        this.mCameraView.setPictureSize(i, i2, true);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cameraLayout.getLayoutParams();
        marginLayoutParams.height = -1;
        this.cameraLayout.setLayoutParams(marginLayoutParams);
        calculatorCameraView();
        setGridMode();
        ImageView imageView = (ImageView) findViewById(R.id.focus);
        this.focus = imageView;
        imageView.setVisibility(8);
        findViewById(R.id.swap).setOnClickListener(this);
        findViewById(R.id.flash).setOnClickListener(this);
        findViewById(R.id.ratio).setOnClickListener(this);
        findViewById(R.id.settings).setOnClickListener(this);
        findViewById(R.id.timer).setOnClickListener(this);
        findViewById(R.id.grid).setOnClickListener(this);
        this.takePhoto.setOnClickListener(this);
        this.timer = (ImageView) findViewById(R.id.clock);
        ArrayList arrayList = new ArrayList();
        this.lstFunctions = arrayList;
        arrayList.add(new Function(findViewById(R.id.light), findViewById(R.id.light_icon), findViewById(R.id.light_name), R.drawable.ic_light, R.drawable.ic_light_selected));
        this.lstFunctions.add(new Function(findViewById(R.id.dust), findViewById(R.id.dust_icon), findViewById(R.id.dust_name), R.drawable.ic_dust, R.drawable.ic_dust_selected));
        this.lstFunctions.add(new Function(findViewById(R.id.mask), findViewById(R.id.mask_icon), findViewById(R.id.mask_name), R.drawable.ic_mask, R.drawable.ic_mask_selected));
        this.lstFunctions.add(new Function(findViewById(R.id.filter), findViewById(R.id.filter_icon), findViewById(R.id.filter_name), R.drawable.ic_filter, R.drawable.ic_filter_selected));
        this.lstFunctions.add(new Function(findViewById(R.id.gradient), findViewById(R.id.gradient_icon), findViewById(R.id.gradient_name), R.drawable.ic_gradient, R.drawable.ic_gradient_selected));
        this.lstFunctions.add(new Function(findViewById(R.id.none), findViewById(R.id.none_icon), findViewById(R.id.none_name), R.drawable.ic_none, R.drawable.ic_none_selected));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvFilter);
        this.rvFilter = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.rvFilter.setHasFixedSize(true);
        findViewById(R.id.gallery).setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.CameraActivity.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirebaseAnalyticsHelper.trackGalleryOpened(CameraActivity.this);
                PhotoPicker.builder().setPhotoCount(1).setPreviewEnabled(false).setShowCamera(false).start(CameraActivity.this);
            }
        });
        this.mCameraView.setOnTouchListener(new View.OnTouchListener() { // from class: com.photolab.vintage.activity.CameraActivity.4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 0) {
                    return true;
                }
                float x = motionEvent.getX() / CameraActivity.this.mCameraView.getWidth();
                float y = motionEvent.getY() / CameraActivity.this.mCameraView.getHeight();
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) CameraActivity.this.focus.getLayoutParams();
                layoutParams.topMargin = ((int) motionEvent.getY()) - CameraActivity.this.delta;
                layoutParams.leftMargin = ((int) motionEvent.getX()) - CameraActivity.this.delta;
                CameraActivity.this.focus.setVisibility(0);
                CameraActivity.this.focus.postDelayed(new Runnable() { // from class: com.photolab.vintage.activity.CameraActivity.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CameraActivity.this.focus.setVisibility(8);
                    }
                }, 1000L);
                CameraActivity.this.mCameraView.focusAtPoint(x, y, new Camera.AutoFocusCallback() { // from class: com.photolab.vintage.activity.CameraActivity.4.2
                    @Override // android.hardware.Camera.AutoFocusCallback
                    public final void onAutoFocus(boolean z, Camera camera) {
                        if (z) {
                            return;
                        }
                        CameraActivity.this.mCameraView.cameraInstance().setFocusMode("continuous-video");
                    }
                });
                return true;
            }
        });
        crack_finction();
        slideDown(this.rvFilter);
        new Thread(new Runnable() { // from class: com.photolab.vintage.activity.CameraActivity.5
            @Override // java.lang.Runnable
            public final void run() {
                CameraActivity.this.lambda$onCreate$4$CameraActivity();
            }
        }).start();
        PermissionsUtils.checkCameraPermission(this);
        slideDown(this.rvFilter);
        initConfigs();
        FilterConfig filterConfig = new FilterConfig();
        filterConfig.setConfig("");
        onFilterSelected(filterConfig);
        resetAdapterEffect();
        this.currentFilterConfig = filterConfig;
        this.intensive.setVisibility(8);
    }

    public void lambda$onCreate$4$CameraActivity() {
        SystemUtil.clearCacheFile(getApplicationContext());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length == 0 || iArr[0] != 0) {
            View viewInflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.permission_camera, this.viewGroup, false);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setView(viewInflate);
            final AlertDialog alertDialogCreate = builder.create();
            viewInflate.findViewById(R.id.oki).setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.CameraActivity.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    alertDialogCreate.dismiss();
                    PermissionsUtils.checkCameraPermission(CameraActivity.this);
                }
            });
            alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            alertDialogCreate.show();
        }
    }

    public void crack_finction() {
        if (this.mCameraView.getRecorder() != null) {
            this.mCameraView.queueEvent(new Runnable() { // from class: com.photolab.vintage.activity.CameraActivity.7
                @Override // java.lang.Runnable
                public final void run() {
                    Iterator it = CameraActivity.this.configs.entrySet().iterator();
                    String str = "";
                    while (it.hasNext()) {
                        str = str + ((String) ((Map.Entry) it.next()).getValue()) + " ";
                    }
                    CameraActivity.this.mCameraView.setFilterWithConfig(str);
                }
            });
        } else {
            this.mCameraView.postDelayed(new Runnable() { // from class: com.photolab.vintage.activity.CameraActivity.8
                @Override // java.lang.Runnable
                public final void run() {
                    CameraActivity.this.crack_finction();
                }
            }, 500L);
        }
    }

    private void calculatorCameraView() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cameraOverlay.getLayoutParams();
        ((RelativeLayout.LayoutParams) this.paddingTop.getLayoutParams()).height = 0;
        marginLayoutParams.height = -1;
        this.ratioValue.setText("FULL");
        this.cameraOverlay.setLayoutParams(marginLayoutParams);
        this.cameraOverlay.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initConfigs() {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        this.configs = linkedHashMap;
        linkedHashMap.put(0, "");
        this.configs.put(2, "");
        this.configs.put(1, "");
        this.configs.put(3, "");
        this.configs.put(4, "");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mCameraView.onResume();
        crack_finction();
        this.isGrid = SharePreferenceUtil.isGridEnabled(this);
        this.countdownSoundEnabled = SharePreferenceUtil.isCountdownSoundEnabled(this);
        setGridMode();
        FilterAdapter filterAdapter = this.filterAdapter;
        if (filterAdapter != null) {
            filterAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        CameraInstance.getInstance().stopCamera();
        this.mCameraView.release(null);
        this.mCameraView.onPause();
    }

    @Override // com.photolab.vintage.util.adapter.FilterAdapter.FilterListener
    public void onFilterSelected(FilterConfig filterConfig) {
        String name;
        this.configs.put(Integer.valueOf(filterConfig.getType()), MessageFormat.format(filterConfig.getConfig(), Integer.valueOf(filterConfig.getIntensive())));
        this.intensive.setProgress(filterConfig.getIntensive() / 100.0f);
        this.intensive.setVisibility(0);
        this.currentFilterConfig = filterConfig;
        if (filterConfig.getConfig().isEmpty() || this.currentFilterConfig.getType() == 0) {
            this.intensive.setVisibility(8);
        }
        if (filterConfig != null && !filterConfig.getConfig().isEmpty() && filterConfig.getType() != 0) {
            if (filterConfig.getName() != null) {
                name = filterConfig.getName();
            } else {
                name = "filter_" + filterConfig.getType();
            }
            String filterTypeName = getFilterTypeName(filterConfig.getType());
            PerformanceHelper.startFilterApplyTrace();
            FirebaseAnalyticsHelper.trackFilterApplied(this, name);
            FirebaseRealtimeHelper.trackFilterApplied(this, name, filterTypeName);
            PerformanceHelper.stopFilterApplyTrace(name, filterTypeName);
        }
        this.mCameraView.queueEvent(new Runnable() { // from class: com.photolab.vintage.activity.CameraActivity.9
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = CameraActivity.this.configs.entrySet().iterator();
                String str = "";
                while (it.hasNext()) {
                    str = str + ((String) ((Map.Entry) it.next()).getValue()) + " ";
                }
                CameraActivity.this.mCameraView.setFilterWithConfig(str.trim());
            }
        });
    }

    /* JADX WARN: Type inference failed for: r8v10, types: [com.photolab.vintage.activity.CameraActivity$10] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.flash) {
            boolean z = !this.isFlashModel;
            this.isFlashModel = z;
            this.flashIcon.setImageResource(z ? R.drawable.ic_flash_on : R.drawable.ic_flash_off);
            this.mCameraView.setFlashLightMode(this.isFlashModel ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            return;
        }
        if (id == R.id.grid) {
            boolean z2 = !this.isGrid;
            this.isGrid = z2;
            SharePreferenceUtil.setGridEnabled(this, z2);
            setGridMode();
            return;
        }
        if (id == R.id.ratio) {
            this.currentMode++;
            calculatorCameraView();
            return;
        }
        if (id == R.id.settings) {
            FirebaseAnalyticsHelper.trackSettingsOpened(this);
            startActivity(new Intent(this, (Class<?>) SettingsActivity.class));
            return;
        }
        if (id == R.id.swap) {
            this.mCameraView.switchCamera();
            return;
        }
        if (id == R.id.takePhoto) {
            this.countDown.setText("");
            this.countDown.setVisibility(0);
            new CountDownTimer(Math.max(this.countDowns.get(this.currentCountDown % 4).getTime(), 0) * 1000, 1000L) { // from class: com.photolab.vintage.activity.CameraActivity.10
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    CameraActivity.this.countDown.setText(((j / 1000) + 1) + "");
                    if (!CameraActivity.this.countdownSoundEnabled || CameraActivity.this.toneGenerator == null) {
                        return;
                    }
                    CameraActivity.this.toneGenerator.startTone(24, 150);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (CameraActivity.this.isFinishing() || CameraActivity.this.isDestroyed()) {
                        return;
                    }
                    CameraActivity.this.countDown.setVisibility(8);
                    try {
                        CameraActivity.this.hud.show();
                        CameraActivity.this.mCameraView.takePicture(new CameraGLSurfaceView.TakePictureCallback() { // from class: com.photolab.vintage.activity.CameraActivity.10.1
                            @Override // org.wysaid.view.CameraGLSurfaceView.TakePictureCallback
                            public final void takePictureOK(Bitmap bitmap) {
                                String name;
                                if (bitmap != null) {
                                    try {
                                        FirebaseAnalyticsHelper.trackPhotoCaptured(CameraActivity.this);
                                        if (CameraActivity.this.currentFilterConfig != null) {
                                            name = CameraActivity.this.currentFilterConfig.getName();
                                        } else {
                                            name = "none";
                                        }
                                        FirebaseRealtimeHelper.trackPhotoCaptured(CameraActivity.this, name);
                                        FirebaseRealtimeHelper.updateAppStats("total_photos_captured", 1L);
                                        CrashlyticsHelper.trackUserAction(FirebaseAnalyticsHelper.EVENT_PHOTO_CAPTURED);
                                        CrashlyticsHelper.setCustomKey("last_filter_used", name);
                                        String strSaveBitmapInCache = ImageUtil.saveBitmapInCache(CameraActivity.this, bitmap);
                                        bitmap.recycle();
                                        CameraActivity.this.hud.dismiss();
                                        Intent intent = new Intent(CameraActivity.this, (Class<?>) EditPhotoActivity.class);
                                        intent.putExtra("0", CameraActivity.this.filterAdapter.getSelectedFilterIndex());
                                        intent.putExtra("0_intensive", CameraActivity.this.filterAdapter.getFilterEffects().get(CameraActivity.this.filterAdapter.getSelectedFilterIndex()).getIntensive());
                                        intent.putExtra("2", CameraActivity.this.dustAdapter.getSelectedFilterIndex());
                                        intent.putExtra("2_intensive", CameraActivity.this.dustAdapter.getFilterEffects().get(CameraActivity.this.dustAdapter.getSelectedFilterIndex()).getIntensive());
                                        intent.putExtra("1", CameraActivity.this.lightAdapter.getSelectedFilterIndex());
                                        intent.putExtra("1_intensive", CameraActivity.this.lightAdapter.getFilterEffects().get(CameraActivity.this.lightAdapter.getSelectedFilterIndex()).getIntensive());
                                        intent.putExtra("4", CameraActivity.this.maskAdapter.getSelectedFilterIndex());
                                        intent.putExtra("4_intensive", CameraActivity.this.maskAdapter.getFilterEffects().get(CameraActivity.this.maskAdapter.getSelectedFilterIndex()).getIntensive());
                                        intent.putExtra("3", CameraActivity.this.gradientAdapter.getSelectedFilterIndex());
                                        intent.putExtra("3_intensive", CameraActivity.this.gradientAdapter.getFilterEffects().get(CameraActivity.this.gradientAdapter.getSelectedFilterIndex()).getIntensive());
                                        intent.putExtra("path", strSaveBitmapInCache);
                                        CameraActivity.this.startActivity(intent);
                                    } catch (Exception e) {
                                        CrashlyticsHelper.logException("Error saving photo", e);
                                        CameraActivity.this.hud.dismiss();
                                    }
                                }
                            }
                        }, null, "", 1.0f, true);
                    } catch (RuntimeException e) {
                        Log.e("CameraActivity", "takePicture failed: " + e.getMessage());
                        CrashlyticsHelper.logException("takePicture failed", e);
                        CameraActivity.this.hud.dismiss();
                        Toast.makeText(CameraActivity.this, "Camera error. Please try again.", 0).show();
                    }
                }
            }.start();
        } else if (id == R.id.timer) {
            int i = this.currentCountDown + 1;
            this.currentCountDown = i;
            this.timer.setImageResource(this.countDowns.get(i % 4).getResource());
        }
    }

    public void slideDown(View view) {
        ObjectAnimator.ofFloat(view, "translationY", 0.0f, view.getHeight() + SystemUtil.dpToPx(getApplicationContext(), 3)).start();
    }

    public void slideUp(View view) {
        ObjectAnimator.ofFloat(view, "translationY", view.getHeight() + SystemUtil.dpToPx(getApplicationContext(), 3), 0.0f).start();
    }

    private void setGridMode() {
        int i = this.isGrid ? 0 : 8;
        findViewById(R.id.line1).setVisibility(i);
        findViewById(R.id.line2).setVisibility(i);
        findViewById(R.id.line3).setVisibility(i);
        findViewById(R.id.line4).setVisibility(i);
    }

    private String getFilterTypeName(int i) {
        if (i == 0) {
            return "none";
        }
        if (i == 1) {
            return "light";
        }
        if (i == 2) {
            return "dust";
        }
        if (i == 3) {
            return "gradient";
        }
        if (i == 4) {
            return "mask";
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public class Function {
        ImageView icon;
        int iconId;
        boolean isSelected;
        TextView name;
        int selectedIconId;
        RelativeLayout wrap;

        Function(View view, View view2, View view3, final int i, int i2) {
            this.wrap = (RelativeLayout) view;
            this.icon = (ImageView) view2;
            this.name = (TextView) view3;
            this.iconId = i;
            this.selectedIconId = i2;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.CameraActivity.Function.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    if (view4.getId() != R.id.none) {
                        Function function = Function.this;
                        function.isSelected = !function.isSelected;
                    }
                    CameraActivity cameraActivity = CameraActivity.this;
                    cameraActivity.slideDown(cameraActivity.rvFilter);
                    if (Function.this.isSelected) {
                        Function.this.icon.setImageResource(i);
                        Function.this.name.setTextColor(Color.parseColor("#00aeef"));
                    }
                    Log.e("lstFunctions", "" + CameraActivity.this.lstFunctions.size());
                    for (int i3 = 0; i3 < CameraActivity.this.lstFunctions.size(); i3++) {
                        Log.e("isSelected", "11" + ((Function) CameraActivity.this.lstFunctions.get(i3)).isSelected);
                    }
                    for (Function function2 : CameraActivity.this.lstFunctions) {
                        if (!Function.this.isSelected || Function.this.name != function2.name) {
                            function2.icon.setImageResource(function2.iconId);
                            function2.name.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                            function2.isSelected = false;
                        }
                    }
                    int id = view4.getId();
                    if (id == R.id.dust) {
                        CameraActivity cameraActivity2 = CameraActivity.this;
                        cameraActivity2.currentFilterConfig = cameraActivity2.dustAdapter.getFilterEffects().get(CameraActivity.this.dustAdapter.getSelectedFilterIndex());
                        CameraActivity.this.rvFilter.setAdapter(CameraActivity.this.dustAdapter);
                        RecyclerView recyclerView = CameraActivity.this.rvFilter;
                        CameraActivity cameraActivity3 = CameraActivity.this;
                        recyclerView.scrollToPosition(cameraActivity3.getPositionToScroll(cameraActivity3.dustAdapter));
                    } else if (id == R.id.filter) {
                        CameraActivity.this.currentFilterConfig = ResourceUtil.getFilterConfig().get(CameraActivity.this.filterAdapter.getSelectedFilterIndex());
                        CameraActivity.this.rvFilter.setAdapter(CameraActivity.this.filterAdapter);
                        RecyclerView recyclerView2 = CameraActivity.this.rvFilter;
                        CameraActivity cameraActivity4 = CameraActivity.this;
                        recyclerView2.scrollToPosition(cameraActivity4.getPositionToScroll(cameraActivity4.filterAdapter));
                    } else if (id == R.id.gradient) {
                        CameraActivity cameraActivity5 = CameraActivity.this;
                        cameraActivity5.currentFilterConfig = cameraActivity5.gradientAdapter.getFilterEffects().get(CameraActivity.this.gradientAdapter.getSelectedFilterIndex());
                        CameraActivity.this.rvFilter.setAdapter(CameraActivity.this.gradientAdapter);
                        RecyclerView recyclerView3 = CameraActivity.this.rvFilter;
                        CameraActivity cameraActivity6 = CameraActivity.this;
                        recyclerView3.scrollToPosition(cameraActivity6.getPositionToScroll(cameraActivity6.gradientAdapter));
                    } else if (id == R.id.light) {
                        CameraActivity cameraActivity7 = CameraActivity.this;
                        cameraActivity7.currentFilterConfig = cameraActivity7.lightAdapter.getFilterEffects().get(CameraActivity.this.lightAdapter.getSelectedFilterIndex());
                        CameraActivity.this.rvFilter.setAdapter(CameraActivity.this.lightAdapter);
                        RecyclerView recyclerView4 = CameraActivity.this.rvFilter;
                        CameraActivity cameraActivity8 = CameraActivity.this;
                        recyclerView4.scrollToPosition(cameraActivity8.getPositionToScroll(cameraActivity8.lightAdapter));
                    } else if (id == R.id.mask) {
                        CameraActivity cameraActivity9 = CameraActivity.this;
                        cameraActivity9.currentFilterConfig = cameraActivity9.maskAdapter.getFilterEffects().get(CameraActivity.this.maskAdapter.getSelectedFilterIndex());
                        CameraActivity.this.rvFilter.setAdapter(CameraActivity.this.maskAdapter);
                        RecyclerView recyclerView5 = CameraActivity.this.rvFilter;
                        CameraActivity cameraActivity10 = CameraActivity.this;
                        recyclerView5.scrollToPosition(cameraActivity10.getPositionToScroll(cameraActivity10.maskAdapter));
                    } else if (id == R.id.none) {
                        CameraActivity cameraActivity11 = CameraActivity.this;
                        cameraActivity11.slideDown(cameraActivity11.rvFilter);
                        CameraActivity.this.initConfigs();
                        FilterConfig filterConfig = new FilterConfig();
                        filterConfig.setConfig("");
                        CameraActivity.this.onFilterSelected(filterConfig);
                        CameraActivity.this.resetAdapterEffect();
                        CameraActivity.this.currentFilterConfig = filterConfig;
                        CameraActivity.this.intensive.setVisibility(8);
                    }
                    if (!Function.this.isSelected) {
                        CameraActivity.this.intensive.setVisibility(8);
                        return;
                    }
                    CameraActivity cameraActivity12 = CameraActivity.this;
                    cameraActivity12.slideUp(cameraActivity12.rvFilter);
                    if (CameraActivity.this.currentFilterConfig.getConfig().isEmpty() || CameraActivity.this.currentFilterConfig.getType() == 0) {
                        CameraActivity.this.intensive.setVisibility(8);
                    } else {
                        CameraActivity.this.intensive.setVisibility(0);
                        CameraActivity.this.intensive.setProgress(CameraActivity.this.currentFilterConfig.getIntensive() / 100.0f);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPositionToScroll(FilterAdapter filterAdapter) {
        if (filterAdapter.getSelectedFilterIndex() <= 2) {
            return 0;
        }
        return filterAdapter.getSelectedFilterIndex() - 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetAdapterEffect() {
        this.lightAdapter.setSelectedFilterIndex(0);
        this.dustAdapter.setSelectedFilterIndex(0);
        this.maskAdapter.setSelectedFilterIndex(0);
        this.gradientAdapter.setSelectedFilterIndex(0);
        this.filterAdapter.setSelectedFilterIndex(0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
