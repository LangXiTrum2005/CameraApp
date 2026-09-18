package com.kaopiz.kprogresshud;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class KProgressHUD {
    private Context mContext;
    private Handler mGraceTimer;
    private int mMaxProgress;
    private ProgressDialog mProgressDialog;
    private int mWindowColor;
    private float mDimAmount = 0.0f;
    private int mAnimateSpeed = 1;
    private float mCornerRadius = 10.0f;
    private boolean mIsAutoDismiss = true;
    private int mGraceTimeMs = 0;
    private boolean mFinished = false;

    public enum Style {
        SPIN_INDETERMINATE,
        PIE_DETERMINATE,
        ANNULAR_DETERMINATE,
        BAR_DETERMINATE
    }

    public KProgressHUD(Context context) {
        this.mContext = context;
        this.mProgressDialog = new ProgressDialog(context);
        this.mWindowColor = context.getResources().getColor(R.color.kprogresshud_default_color);
        setStyle(Style.SPIN_INDETERMINATE);
    }

    public static KProgressHUD create(Context context) {
        return new KProgressHUD(context);
    }

    public static KProgressHUD create(Context context, Style style) {
        return new KProgressHUD(context).setStyle(style);
    }

    /* JADX INFO: renamed from: com.kaopiz.kprogresshud.KProgressHUD$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style;

        static {
            int[] iArr = new int[Style.values().length];
            $SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style = iArr;
            try {
                iArr[Style.SPIN_INDETERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style[Style.PIE_DETERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style[Style.ANNULAR_DETERMINATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style[Style.BAR_DETERMINATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public KProgressHUD setStyle(Style style) {
        View spinView;
        int i = AnonymousClass2.$SwitchMap$com$kaopiz$kprogresshud$KProgressHUD$Style[style.ordinal()];
        if (i == 1) {
            spinView = new SpinView(this.mContext);
        } else if (i == 2) {
            spinView = new PieView(this.mContext);
        } else if (i == 3) {
            spinView = new AnnularView(this.mContext);
        } else {
            spinView = i != 4 ? null : new BarView(this.mContext);
        }
        this.mProgressDialog.setView(spinView);
        return this;
    }

    public KProgressHUD setDimAmount(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.mDimAmount = f;
        }
        return this;
    }

    public KProgressHUD setSize(int i, int i2) {
        this.mProgressDialog.setSize(i, i2);
        return this;
    }

    @Deprecated
    public KProgressHUD setWindowColor(int i) {
        this.mWindowColor = i;
        return this;
    }

    public KProgressHUD setBackgroundColor(int i) {
        this.mWindowColor = i;
        return this;
    }

    public KProgressHUD setCornerRadius(float f) {
        this.mCornerRadius = f;
        return this;
    }

    public KProgressHUD setAnimationSpeed(int i) {
        this.mAnimateSpeed = i;
        return this;
    }

    public KProgressHUD setLabel(String str) {
        this.mProgressDialog.setLabel(str);
        return this;
    }

    public KProgressHUD setLabel(String str, int i) {
        this.mProgressDialog.setLabel(str, i);
        return this;
    }

    public KProgressHUD setDetailsLabel(String str) {
        this.mProgressDialog.setDetailsLabel(str);
        return this;
    }

    public KProgressHUD setDetailsLabel(String str, int i) {
        this.mProgressDialog.setDetailsLabel(str, i);
        return this;
    }

    public KProgressHUD setMaxProgress(int i) {
        this.mMaxProgress = i;
        return this;
    }

    public void setProgress(int i) {
        this.mProgressDialog.setProgress(i);
    }

    public KProgressHUD setCustomView(View view) {
        if (view != null) {
            this.mProgressDialog.setView(view);
            return this;
        }
        throw new RuntimeException("Custom view must not be null!");
    }

    public KProgressHUD setCancellable(boolean z) {
        this.mProgressDialog.setCancelable(z);
        this.mProgressDialog.setOnCancelListener(null);
        return this;
    }

    public KProgressHUD setCancellable(DialogInterface.OnCancelListener onCancelListener) {
        this.mProgressDialog.setCancelable(onCancelListener != null);
        this.mProgressDialog.setOnCancelListener(onCancelListener);
        return this;
    }

    public KProgressHUD setAutoDismiss(boolean z) {
        this.mIsAutoDismiss = z;
        return this;
    }

    public KProgressHUD setGraceTime(int i) {
        this.mGraceTimeMs = i;
        return this;
    }

    public KProgressHUD show() {
        if (!isShowing()) {
            this.mFinished = false;
            if (this.mGraceTimeMs == 0) {
                this.mProgressDialog.show();
            } else {
                Handler handler = new Handler();
                this.mGraceTimer = handler;
                handler.postDelayed(new Runnable() { // from class: com.kaopiz.kprogresshud.KProgressHUD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (KProgressHUD.this.mProgressDialog == null || KProgressHUD.this.mFinished) {
                            return;
                        }
                        KProgressHUD.this.mProgressDialog.show();
                    }
                }, this.mGraceTimeMs);
            }
        }
        return this;
    }

    public boolean isShowing() {
        ProgressDialog progressDialog = this.mProgressDialog;
        return progressDialog != null && progressDialog.isShowing();
    }

    public void dismiss() {
        ProgressDialog progressDialog;
        this.mFinished = true;
        if (this.mContext != null && (progressDialog = this.mProgressDialog) != null && progressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
        Handler handler = this.mGraceTimer;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mGraceTimer = null;
        }
    }

    private class ProgressDialog extends Dialog {
        private BackgroundLayout mBackgroundLayout;
        private FrameLayout mCustomViewContainer;
        private int mDetailColor;
        private String mDetailsLabel;
        private TextView mDetailsText;
        private Determinate mDeterminateView;
        private int mHeight;
        private Indeterminate mIndeterminateView;
        private String mLabel;
        private int mLabelColor;
        private TextView mLabelText;
        private View mView;
        private int mWidth;

        public ProgressDialog(Context context) {
            super(context);
            this.mLabelColor = -1;
            this.mDetailColor = -1;
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(R.layout.kprogresshud_hud);
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.addFlags(2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = KProgressHUD.this.mDimAmount;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            setCanceledOnTouchOutside(false);
            initViews();
        }

        private void initViews() {
            BackgroundLayout backgroundLayout = (BackgroundLayout) findViewById(R.id.background);
            this.mBackgroundLayout = backgroundLayout;
            backgroundLayout.setBaseColor(KProgressHUD.this.mWindowColor);
            this.mBackgroundLayout.setCornerRadius(KProgressHUD.this.mCornerRadius);
            if (this.mWidth != 0) {
                updateBackgroundSize();
            }
            this.mCustomViewContainer = (FrameLayout) findViewById(R.id.container);
            addViewToFrame(this.mView);
            Determinate determinate = this.mDeterminateView;
            if (determinate != null) {
                determinate.setMax(KProgressHUD.this.mMaxProgress);
            }
            Indeterminate indeterminate = this.mIndeterminateView;
            if (indeterminate != null) {
                indeterminate.setAnimationSpeed(KProgressHUD.this.mAnimateSpeed);
            }
            this.mLabelText = (TextView) findViewById(R.id.label);
            setLabel(this.mLabel, this.mLabelColor);
            this.mDetailsText = (TextView) findViewById(R.id.details_label);
            setDetailsLabel(this.mDetailsLabel, this.mDetailColor);
        }

        private void addViewToFrame(View view) {
            if (view == null) {
                return;
            }
            this.mCustomViewContainer.addView(view, new ViewGroup.LayoutParams(-2, -2));
        }

        private void updateBackgroundSize() {
            ViewGroup.LayoutParams layoutParams = this.mBackgroundLayout.getLayoutParams();
            layoutParams.width = Helper.dpToPixel(this.mWidth, getContext());
            layoutParams.height = Helper.dpToPixel(this.mHeight, getContext());
            this.mBackgroundLayout.setLayoutParams(layoutParams);
        }

        public void setProgress(int i) {
            Determinate determinate = this.mDeterminateView;
            if (determinate != null) {
                determinate.setProgress(i);
                if (!KProgressHUD.this.mIsAutoDismiss || i < KProgressHUD.this.mMaxProgress) {
                    return;
                }
                dismiss();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setView(View view) {
            if (view != 0) {
                if (view instanceof Determinate) {
                    this.mDeterminateView = (Determinate) view;
                }
                if (view instanceof Indeterminate) {
                    this.mIndeterminateView = (Indeterminate) view;
                }
                this.mView = view;
                if (isShowing()) {
                    this.mCustomViewContainer.removeAllViews();
                    addViewToFrame(view);
                }
            }
        }

        public void setLabel(String str) {
            this.mLabel = str;
            TextView textView = this.mLabelText;
            if (textView != null) {
                if (str != null) {
                    textView.setText(str);
                    this.mLabelText.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            }
        }

        public void setDetailsLabel(String str) {
            this.mDetailsLabel = str;
            TextView textView = this.mDetailsText;
            if (textView != null) {
                if (str != null) {
                    textView.setText(str);
                    this.mDetailsText.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            }
        }

        public void setLabel(String str, int i) {
            this.mLabel = str;
            this.mLabelColor = i;
            TextView textView = this.mLabelText;
            if (textView != null) {
                if (str != null) {
                    textView.setText(str);
                    this.mLabelText.setTextColor(i);
                    this.mLabelText.setVisibility(0);
                    return;
                }
                textView.setVisibility(8);
            }
        }

        public void setDetailsLabel(String str, int i) {
            this.mDetailsLabel = str;
            this.mDetailColor = i;
            TextView textView = this.mDetailsText;
            if (textView != null) {
                if (str != null) {
                    textView.setText(str);
                    this.mDetailsText.setTextColor(i);
                    this.mDetailsText.setVisibility(0);
                    return;
                }
                textView.setVisibility(8);
            }
        }

        public void setSize(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
            if (this.mBackgroundLayout != null) {
                updateBackgroundSize();
            }
        }
    }
}
