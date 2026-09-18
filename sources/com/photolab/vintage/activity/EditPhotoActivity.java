package com.photolab.vintage.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.EnvironmentCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.photolab.vintage.R;
import com.photolab.vintage.util.AdManager;
import com.photolab.vintage.util.CrashlyticsHelper;
import com.photolab.vintage.util.FirebaseAnalyticsHelper;
import com.photolab.vintage.util.FirebaseRealtimeHelper;
import com.photolab.vintage.util.ImageUtil;
import com.photolab.vintage.util.PerformanceHelper;
import com.photolab.vintage.util.ResourceUtil;
import com.photolab.vintage.util.SharePreferenceUtil;
import com.photolab.vintage.util.SystemUtil;
import com.photolab.vintage.util.adapter.AdjustAdapter;
import com.photolab.vintage.util.adapter.AdjustListener;
import com.photolab.vintage.util.adapter.ColorAdapter;
import com.photolab.vintage.util.adapter.EditingToolsAdapter;
import com.photolab.vintage.util.adapter.FilterAdapter;
import com.photolab.vintage.util.bean.FilterConfig;
import com.photolab.vintage.util.picker.utils.PermissionsUtils;
import com.photolab.vintage.view.ToolType;
import com.photolab.vintage.view.VerticalSlider;
import java.io.File;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.wysaid.view.ImageGLSurfaceView;

/* JADX INFO: loaded from: classes2.dex */
public class EditPhotoActivity extends AppCompatActivity implements EditingToolsAdapter.OnItemSelected, FilterAdapter.FilterListener, AdjustListener, ColorAdapter.ColorChangeListener {
    private LinearLayout adjust;
    private DegreeSeekBar adjustLevel;
    private LinkedHashMap<Integer, String> configs;
    private FilterConfig currentFilterConfig;
    private FilterAdapter dustAdapter;
    private FilterAdapter filterAdapter;
    private ImageGLSurfaceView glSurfaceView;
    private FilterAdapter gradientAdapter;
    private KProgressHUD hud;
    private VerticalSlider intensive;
    private FilterAdapter lightAdapter;
    private AdjustAdapter mAdjustAdapter;
    private Bitmap mBitmap;
    private RecyclerView mRvFilterView;
    private RecyclerView mRvTools;
    private FilterAdapter maskAdapter;
    private RecyclerView rvAdjust;
    private boolean saveOriginalEnabled;
    private ViewGroup viewGroup;
    private FrameLayout wrapPicture;
    private ToolType currentTool = ToolType.NONE;
    private EditingToolsAdapter mEditingToolsAdapter = new EditingToolsAdapter(this);

    @Override // com.photolab.vintage.util.adapter.ColorAdapter.ColorChangeListener
    public void onChange(String str) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.edit_layout);
        PerformanceHelper.startScreenTrace("EditPhotoActivity");
        CrashlyticsHelper.trackScreen("EditPhotoActivity");
        FirebaseAnalyticsHelper.trackEditStarted(this);
        this.viewGroup = (ViewGroup) findViewById(android.R.id.content);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("0", 0);
        int intExtra2 = intent.getIntExtra("2", 0);
        int intExtra3 = intent.getIntExtra("2_intensive", 100);
        int intExtra4 = intent.getIntExtra("1", 0);
        int intExtra5 = intent.getIntExtra("1_intensive", 80);
        int intExtra6 = intent.getIntExtra("4", 0);
        int intExtra7 = intent.getIntExtra("4_intensive", 25);
        int intExtra8 = intent.getIntExtra("3", 0);
        int intExtra9 = intent.getIntExtra("3_intensive", 40);
        final String stringExtra = intent.getStringExtra("path");
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.EditPhotoActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPhotoActivity.this.finish();
            }
        });
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.EditPhotoActivity.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 33) {
                    EditPhotoActivity.this.new SaveFilterAsBitmap().execute(new Void[0]);
                } else if (PermissionsUtils.checkWriteStoragePermission(EditPhotoActivity.this)) {
                    EditPhotoActivity.this.new SaveFilterAsBitmap().execute(new Void[0]);
                }
            }
        });
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        this.configs = linkedHashMap;
        linkedHashMap.put(5, "");
        this.configs.put(0, MessageFormat.format(ResourceUtil.getFilterConfig().get(intExtra).getConfig(), 100));
        this.configs.put(2, MessageFormat.format(ResourceUtil.getDustConfig().get(intExtra2).getConfig(), Integer.valueOf(intExtra3)));
        this.configs.put(1, MessageFormat.format(ResourceUtil.getLightConfig().get(intExtra4).getConfig(), Integer.valueOf(intExtra5)));
        this.configs.put(3, MessageFormat.format(ResourceUtil.getGradientConfig().get(intExtra8).getConfig(), Integer.valueOf(intExtra9)));
        this.configs.put(4, MessageFormat.format(ResourceUtil.getMaskConfig().get(intExtra6).getConfig(), Integer.valueOf(intExtra7)));
        VerticalSlider verticalSlider = (VerticalSlider) findViewById(R.id.intensive);
        this.intensive = verticalSlider;
        verticalSlider.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvConstraintTools);
        this.mRvTools = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.mRvTools.setAdapter(this.mEditingToolsAdapter);
        this.wrapPicture = (FrameLayout) findViewById(R.id.wrapPicture);
        this.adjust = (LinearLayout) findViewById(R.id.adjust);
        this.adjustLevel = (DegreeSeekBar) findViewById(R.id.adjustLevel);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.rvAdjustView);
        this.rvAdjust = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.rvAdjust.setHasFixedSize(true);
        AdjustAdapter adjustAdapter = new AdjustAdapter(getApplicationContext(), this);
        this.mAdjustAdapter = adjustAdapter;
        this.rvAdjust.setAdapter(adjustAdapter);
        FilterAdapter filterAdapter = new FilterAdapter(this, this, ResourceUtil.getDustConfig());
        this.dustAdapter = filterAdapter;
        filterAdapter.setSelectedFilterIndex(intExtra2);
        this.dustAdapter.getFilterEffects().get(intExtra2).setIntensive(intExtra3);
        FilterAdapter filterAdapter2 = new FilterAdapter(this, this, ResourceUtil.getFilterConfig());
        this.filterAdapter = filterAdapter2;
        filterAdapter2.setSelectedFilterIndex(intExtra);
        FilterAdapter filterAdapter3 = new FilterAdapter(this, this, ResourceUtil.getLightConfig());
        this.lightAdapter = filterAdapter3;
        filterAdapter3.setSelectedFilterIndex(intExtra4);
        this.lightAdapter.getFilterEffects().get(intExtra4).setIntensive(intExtra5);
        FilterAdapter filterAdapter4 = new FilterAdapter(this, this, ResourceUtil.getMaskConfig());
        this.maskAdapter = filterAdapter4;
        filterAdapter4.setSelectedFilterIndex(intExtra6);
        this.maskAdapter.getFilterEffects().get(intExtra6).setIntensive(intExtra7);
        FilterAdapter filterAdapter5 = new FilterAdapter(this, this, ResourceUtil.getGradientConfig());
        this.gradientAdapter = filterAdapter5;
        filterAdapter5.setSelectedFilterIndex(intExtra8);
        this.gradientAdapter.getFilterEffects().get(intExtra8).setIntensive(intExtra9);
        this.saveOriginalEnabled = SharePreferenceUtil.isSaveOriginalEnabled(this);
        this.mRvFilterView = (RecyclerView) findViewById(R.id.rvFilterView);
        ImageGLSurfaceView imageGLSurfaceView = (ImageGLSurfaceView) findViewById(R.id.mainImageView);
        this.glSurfaceView = imageGLSurfaceView;
        imageGLSurfaceView.setDisplayMode(ImageGLSurfaceView.DisplayMode.DISPLAY_ASPECT_FILL);
        this.glSurfaceView.setSurfaceCreatedCallback(new ImageGLSurfaceView.OnSurfaceCreatedCallback() { // from class: com.photolab.vintage.activity.EditPhotoActivity.3
            @Override // org.wysaid.view.ImageGLSurfaceView.OnSurfaceCreatedCallback
            public final void surfaceCreated() {
                try {
                    Uri uriFromFile = Uri.fromFile(new File(stringExtra));
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(EditPhotoActivity.this.getContentResolver(), uriFromFile);
                    if (Build.VERSION.SDK_INT >= 24) {
                        EditPhotoActivity editPhotoActivity = EditPhotoActivity.this;
                        EditPhotoActivity$3$$ExternalSyntheticApiModelOutline0.m();
                        editPhotoActivity.mBitmap = SystemUtil.rotateBitmap(bitmap, EditPhotoActivity$3$$ExternalSyntheticApiModelOutline0.m(EditPhotoActivity.this.getContentResolver().openInputStream(uriFromFile)).getAttributeInt("Orientation", 1));
                    }
                    EditPhotoActivity.this.glSurfaceView.setImageBitmap(EditPhotoActivity.this.mBitmap);
                    String str = "";
                    Iterator it = EditPhotoActivity.this.configs.entrySet().iterator();
                    while (it.hasNext()) {
                        str = str + ((String) ((Map.Entry) it.next()).getValue()) + " ";
                    }
                    EditPhotoActivity.this.glSurfaceView.setFilterWithConfig(str);
                    if (EditPhotoActivity.this.mBitmap != bitmap) {
                        bitmap.recycle();
                    }
                } catch (Exception unused) {
                }
            }
        });
        this.intensive.setOnSliderProgressChangeListener(new VerticalSlider.OnProgressChangeListener() { // from class: com.photolab.vintage.activity.EditPhotoActivity.4
            @Override // com.photolab.vintage.view.VerticalSlider.OnProgressChangeListener
            public void onProgress(float f) {
            }

            @Override // com.photolab.vintage.view.VerticalSlider.OnProgressChangeListener
            public void onFinish() {
                if (EditPhotoActivity.this.currentFilterConfig != null) {
                    EditPhotoActivity.this.currentFilterConfig.setIntensive((int) (EditPhotoActivity.this.intensive.getProgress() * 100.0f));
                    EditPhotoActivity editPhotoActivity = EditPhotoActivity.this;
                    editPhotoActivity.onFilterSelected(editPhotoActivity.currentFilterConfig);
                    return;
                }
                EditPhotoActivity.this.intensive.setVisibility(8);
            }
        });
        this.glSurfaceView.setDisplayMode(ImageGLSurfaceView.DisplayMode.DISPLAY_ASPECT_FILL);
        this.adjustLevel.setDegreeRange(-50, 50);
        this.adjustLevel.setScrollingListener(new DegreeSeekBar.ScrollingListener() { // from class: com.photolab.vintage.activity.EditPhotoActivity.5
            @Override // com.photolab.vintage.activity.DegreeSeekBar.ScrollingListener
            public void onScrollStart() {
            }

            @Override // com.photolab.vintage.activity.DegreeSeekBar.ScrollingListener
            public void onScroll(int i) {
                AdjustAdapter.AdjustModel currentAdjustModel = EditPhotoActivity.this.mAdjustAdapter.getCurrentAdjustModel();
                currentAdjustModel.originValue = (Math.abs(i + 50) * ((currentAdjustModel.maxValue - ((currentAdjustModel.maxValue + currentAdjustModel.minValue) / 2.0f)) / 50.0f)) + currentAdjustModel.minValue;
            }

            @Override // com.photolab.vintage.activity.DegreeSeekBar.ScrollingListener
            public void onScrollEnd() {
                EditPhotoActivity.this.configs.put(5, EditPhotoActivity.this.mAdjustAdapter.getFilterConfig());
                Iterator it = EditPhotoActivity.this.configs.entrySet().iterator();
                String str = "";
                while (it.hasNext()) {
                    str = str + ((String) ((Map.Entry) it.next()).getValue()) + " ";
                }
                EditPhotoActivity.this.glSurfaceView.setFilterWithConfig(str);
            }
        });
        this.hud = KProgressHUD.create(this).setStyle(KProgressHUD.Style.ANNULAR_DETERMINATE).setDimAmount(1.0f).setLabel("Saving...").setMaxProgress(100);
        this.adjust.setAlpha(0.0f);
        this.mRvFilterView.setAlpha(0.0f);
        this.mRvFilterView.setVisibility(8);
        this.adjust.setVisibility(8);
        this.mRvTools.setAlpha(1.0f);
        this.mRvTools.setVisibility(0);
        findViewById(R.id.activitylayout).post(new Runnable() { // from class: com.photolab.vintage.activity.EditPhotoActivity.6
            @Override // java.lang.Runnable
            public final void run() {
                EditPhotoActivity editPhotoActivity = EditPhotoActivity.this;
                editPhotoActivity.slideDown(editPhotoActivity.adjust);
                EditPhotoActivity editPhotoActivity2 = EditPhotoActivity.this;
                editPhotoActivity2.slideDown(editPhotoActivity2.mRvFilterView);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length == 0 || iArr[0] != 0) {
            View viewInflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.permission_storage, this.viewGroup, false);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setView(viewInflate);
            final AlertDialog alertDialogCreate = builder.create();
            viewInflate.findViewById(R.id.oki).setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.EditPhotoActivity.7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    alertDialogCreate.dismiss();
                    PermissionsUtils.checkCameraPermission(EditPhotoActivity.this);
                }
            });
            alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            alertDialogCreate.show();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.currentTool == null) {
            super.onBackPressed();
        }
        switch (AnonymousClass9.$SwitchMap$com$photolab$vintage$view$ToolType[this.currentTool.ordinal()]) {
            case 1:
                slideDown(this.mRvFilterView);
                this.currentTool = ToolType.NONE;
                break;
            case 2:
                slideDown(this.adjust);
                this.currentTool = ToolType.NONE;
                break;
            case 3:
                slideDown(this.mRvFilterView);
                this.currentTool = ToolType.NONE;
                break;
            case 4:
                slideDown(this.mRvFilterView);
                this.currentTool = ToolType.NONE;
                break;
            case 5:
                slideDown(this.mRvFilterView);
                this.currentTool = ToolType.NONE;
                break;
            case 6:
                slideDown(this.mRvFilterView);
                this.currentTool = ToolType.NONE;
                break;
            case 7:
                this.currentTool = null;
                Toast.makeText(getApplicationContext(), "Press one more time to exit", 0).show();
                break;
        }
    }

    /* JADX INFO: renamed from: com.photolab.vintage.activity.EditPhotoActivity$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$com$photolab$vintage$view$ToolType;

        static {
            int[] iArr = new int[ToolType.values().length];
            $SwitchMap$com$photolab$vintage$view$ToolType = iArr;
            try {
                iArr[ToolType.DUST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$photolab$vintage$view$ToolType[ToolType.ADJUST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$photolab$vintage$view$ToolType[ToolType.FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$photolab$vintage$view$ToolType[ToolType.MASK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$photolab$vintage$view$ToolType[ToolType.LIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$photolab$vintage$view$ToolType[ToolType.GRADIENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$photolab$vintage$view$ToolType[ToolType.NONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.glSurfaceView.release();
        this.glSurfaceView.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.glSurfaceView.onResume();
    }

    public void slideDown(View view) {
        ObjectAnimator.ofFloat(view, "translationY", 0.0f, view.getHeight()).start();
    }

    public void slideUp(View view) {
        ObjectAnimator.ofFloat(view, "translationY", view.getHeight(), 0.0f).start();
    }

    @Override // com.photolab.vintage.util.adapter.EditingToolsAdapter.OnItemSelected
    public void onToolSelected(ToolType toolType) {
        PerformanceHelper.startPhotoEditTrace();
        FirebaseAnalyticsHelper.trackEditToolSelected(this, toolType.name());
        FirebaseRealtimeHelper.trackPhotoEdited(this, toolType.name());
        PerformanceHelper.stopPhotoEditTrace(toolType.name());
        switch (AnonymousClass9.$SwitchMap$com$photolab$vintage$view$ToolType[toolType.ordinal()]) {
            case 1:
                this.mRvFilterView.setAdapter(this.dustAdapter);
                if (this.currentTool == ToolType.ADJUST) {
                    slideDown(this.adjust);
                } else if (this.currentTool == ToolType.DUST) {
                    slideDown(this.mRvFilterView);
                }
                if (this.currentTool == ToolType.DUST) {
                    this.currentTool = ToolType.NONE;
                    this.intensive.setVisibility(8);
                    hideEditorPanelIfNoTool();
                } else {
                    this.mRvFilterView.setVisibility(0);
                    this.mRvFilterView.setAlpha(0.0f);
                    slideUp(this.mRvFilterView);
                    this.mRvFilterView.animate().alpha(1.0f).setDuration(200L).start();
                    this.currentTool = ToolType.DUST;
                    this.currentFilterConfig = this.dustAdapter.getFilterEffects().get(this.dustAdapter.getSelectedFilterIndex());
                    this.intensive.setVisibility(0);
                    this.mRvFilterView.scrollToPosition(getPositionToScroll(this.dustAdapter));
                }
                break;
            case 2:
                if (this.currentTool == ToolType.ADJUST) {
                    slideDown(this.adjust);
                    this.currentTool = ToolType.NONE;
                    hideEditorPanelIfNoTool();
                } else if (this.currentTool != ToolType.NONE) {
                    slideDown(this.mRvFilterView);
                }
                if (this.currentTool != ToolType.ADJUST) {
                    this.adjust.setVisibility(0);
                    this.adjust.setAlpha(0.0f);
                    slideUp(this.adjust);
                    this.adjust.animate().alpha(1.0f).setDuration(200L).start();
                    this.currentTool = ToolType.ADJUST;
                }
                this.intensive.setVisibility(8);
                break;
            case 3:
                this.mRvFilterView.setAdapter(this.filterAdapter);
                if (this.currentTool == ToolType.ADJUST) {
                    slideDown(this.adjust);
                } else if (this.currentTool == ToolType.FILTER) {
                    slideDown(this.mRvFilterView);
                }
                if (this.currentTool == ToolType.FILTER) {
                    this.currentTool = ToolType.NONE;
                    this.intensive.setVisibility(8);
                    hideEditorPanelIfNoTool();
                } else {
                    this.mRvFilterView.setVisibility(0);
                    this.mRvFilterView.setAlpha(0.0f);
                    slideUp(this.mRvFilterView);
                    this.mRvFilterView.animate().alpha(1.0f).setDuration(200L).start();
                    this.currentTool = ToolType.FILTER;
                    this.currentFilterConfig = this.filterAdapter.getFilterEffects().get(this.filterAdapter.getSelectedFilterIndex());
                    this.intensive.setVisibility(0);
                    this.mRvFilterView.scrollToPosition(getPositionToScroll(this.filterAdapter));
                }
                break;
            case 4:
                AdManager.getInstance().showInterstitial(this, null);
                this.mRvFilterView.setAdapter(this.maskAdapter);
                if (this.currentTool == ToolType.ADJUST) {
                    slideDown(this.adjust);
                } else if (this.currentTool == ToolType.MASK) {
                    slideDown(this.mRvFilterView);
                }
                if (this.currentTool == ToolType.MASK) {
                    this.currentTool = ToolType.NONE;
                    this.intensive.setVisibility(8);
                    hideEditorPanelIfNoTool();
                } else {
                    this.mRvFilterView.setVisibility(0);
                    this.mRvFilterView.setAlpha(0.0f);
                    slideUp(this.mRvFilterView);
                    this.mRvFilterView.animate().alpha(1.0f).setDuration(200L).start();
                    this.currentTool = ToolType.MASK;
                    this.currentFilterConfig = this.maskAdapter.getFilterEffects().get(this.maskAdapter.getSelectedFilterIndex());
                    this.intensive.setVisibility(0);
                    this.mRvFilterView.scrollToPosition(getPositionToScroll(this.maskAdapter));
                }
                break;
            case 5:
                this.mRvFilterView.setAdapter(this.lightAdapter);
                if (this.currentTool == ToolType.ADJUST) {
                    slideDown(this.adjust);
                } else if (this.currentTool == ToolType.LIGHT) {
                    slideDown(this.mRvFilterView);
                }
                if (this.currentTool == ToolType.LIGHT) {
                    this.currentTool = ToolType.NONE;
                    this.intensive.setVisibility(8);
                    hideEditorPanelIfNoTool();
                } else {
                    this.mRvFilterView.setVisibility(0);
                    this.mRvFilterView.setAlpha(0.0f);
                    slideUp(this.mRvFilterView);
                    this.mRvFilterView.animate().alpha(1.0f).setDuration(200L).start();
                    this.currentTool = ToolType.LIGHT;
                    this.currentFilterConfig = this.lightAdapter.getFilterEffects().get(this.lightAdapter.getSelectedFilterIndex());
                    this.intensive.setVisibility(0);
                    this.mRvFilterView.scrollToPosition(getPositionToScroll(this.lightAdapter));
                }
                break;
            case 6:
                this.mRvFilterView.setAdapter(this.gradientAdapter);
                if (this.currentTool == ToolType.ADJUST) {
                    slideDown(this.adjust);
                } else if (this.currentTool == ToolType.GRADIENT) {
                    slideDown(this.mRvFilterView);
                }
                if (this.currentTool == ToolType.GRADIENT) {
                    this.currentTool = ToolType.NONE;
                    this.intensive.setVisibility(8);
                    hideEditorPanelIfNoTool();
                } else {
                    this.mRvFilterView.setVisibility(0);
                    this.mRvFilterView.setAlpha(0.0f);
                    slideUp(this.mRvFilterView);
                    this.mRvFilterView.animate().alpha(1.0f).setDuration(200L).start();
                    this.currentTool = ToolType.GRADIENT;
                    this.currentFilterConfig = this.gradientAdapter.getFilterEffects().get(this.gradientAdapter.getSelectedFilterIndex());
                    this.intensive.setVisibility(0);
                    this.mRvFilterView.scrollToPosition(getPositionToScroll(this.gradientAdapter));
                }
                break;
        }
        FilterConfig filterConfig = this.currentFilterConfig;
        if (filterConfig != null) {
            this.intensive.setProgress(filterConfig.getIntensive() / 100.0f);
            if (this.currentFilterConfig.getConfig().isEmpty() || this.currentFilterConfig.getType() == 0) {
                this.intensive.setVisibility(8);
            }
        }
    }

    private int getPositionToScroll(FilterAdapter filterAdapter) {
        if (filterAdapter.getSelectedFilterIndex() <= 2) {
            return 0;
        }
        return filterAdapter.getSelectedFilterIndex() - 2;
    }

    private void hideEditorPanelIfNoTool() {
        if (this.currentTool == ToolType.NONE) {
            this.mRvFilterView.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.photolab.vintage.activity.EditPhotoActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    EditPhotoActivity.this.mRvFilterView.setVisibility(8);
                }
            }).start();
        }
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
            FirebaseAnalyticsHelper.trackFilterApplied(this, name);
            FirebaseRealtimeHelper.trackFilterApplied(this, name, getFilterTypeName(filterConfig.getType()));
        }
        Iterator<Map.Entry<Integer, String>> it = this.configs.entrySet().iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next().getValue() + " ";
        }
        this.glSurfaceView.setFilterWithConfig(str);
    }

    @Override // com.photolab.vintage.util.adapter.AdjustListener
    public void onAdjustSelected(AdjustAdapter.AdjustModel adjustModel) {
        this.adjustLevel.setCurrentDegrees(((int) ((adjustModel.originValue - adjustModel.minValue) / ((adjustModel.maxValue - ((adjustModel.maxValue + adjustModel.minValue) / 2.0f)) / 50.0f))) - 50);
    }

    class SaveFilterAsBitmap extends AsyncTask<Void, Void, String> {
        SaveFilterAsBitmap() {
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            EditPhotoActivity.this.hud.show();
        }

        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            Bitmap bitmap;
            try {
                final Bitmap[] bitmapArr = new Bitmap[1];
                EditPhotoActivity.this.glSurfaceView.getResultBitmap(new ImageGLSurfaceView.QueryResultBitmapCallback() { // from class: com.photolab.vintage.activity.EditPhotoActivity.SaveFilterAsBitmap.1
                    @Override // org.wysaid.view.ImageGLSurfaceView.QueryResultBitmapCallback
                    public final void get(Bitmap bitmap2) {
                        bitmapArr[0] = bitmap2;
                    }
                });
                ImageUtil.setDefaultFolder("VintageCamera");
                while (true) {
                    bitmap = bitmapArr[0];
                    if (bitmap != null) {
                        break;
                    }
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    e.printStackTrace();
                    return "";
                }
                String strSaveBitmap = ImageUtil.saveBitmap(EditPhotoActivity.this, bitmap);
                if (EditPhotoActivity.this.saveOriginalEnabled && EditPhotoActivity.this.mBitmap != null) {
                    EditPhotoActivity editPhotoActivity = EditPhotoActivity.this;
                    ImageUtil.saveBitmap(editPhotoActivity, editPhotoActivity.mBitmap);
                }
                return strSaveBitmap;
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            try {
                EditPhotoActivity.this.hud.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.e("ddd", "" + str);
            if (str != null && !str.isEmpty()) {
                FirebaseAnalyticsHelper.trackPhotoSaved(EditPhotoActivity.this);
                FirebaseRealtimeHelper.updateAppStats("total_photos_saved", 1L);
            }
            MediaScannerConnection.scanFile(EditPhotoActivity.this.getApplicationContext(), new String[]{str}, null, null);
            Intent intent = new Intent(EditPhotoActivity.this, (Class<?>) SaveAndShareActivity.class);
            intent.putExtra("path", str);
            EditPhotoActivity.this.startActivity(intent);
        }
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
        if (i == 5) {
            return "adjust";
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }
}
