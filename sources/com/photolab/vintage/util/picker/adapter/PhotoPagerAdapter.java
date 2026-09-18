package com.photolab.vintage.util.picker.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.google.logging.type.LogSeverity;
import com.photolab.vintage.R;
import com.photolab.vintage.util.picker.utils.AndroidLifecycleUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoPagerAdapter extends PagerAdapter {
    private RequestManager mGlide;
    private List<String> paths;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public PhotoPagerAdapter(RequestManager requestManager, List<String> list) {
        new ArrayList();
        this.paths = list;
        this.mGlide = requestManager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Uri uriFromFile;
        final Context context = viewGroup.getContext();
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.__picker_picker_item_pager, viewGroup, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_pager);
        String str = this.paths.get(i);
        if (str.startsWith("http")) {
            uriFromFile = Uri.parse(str);
        } else {
            uriFromFile = Uri.fromFile(new File(str));
        }
        if (AndroidLifecycleUtils.canLoadImage(context)) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.dontAnimate().dontTransform().override(LogSeverity.EMERGENCY_VALUE, LogSeverity.EMERGENCY_VALUE);
            this.mGlide.setDefaultRequestOptions(requestOptions).load(uriFromFile).thumbnail(0.1f).into(imageView);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.util.picker.adapter.PhotoPagerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Context context2 = context;
                if (!(context2 instanceof Activity) || ((Activity) context2).isFinishing()) {
                    return;
                }
                ((Activity) context).onBackPressed();
            }
        });
        viewGroup.addView(viewInflate);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.paths.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.mGlide.clear(view);
    }
}
