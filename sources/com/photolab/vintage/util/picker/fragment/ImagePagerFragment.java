package com.photolab.vintage.util.picker.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Glide;
import com.photolab.vintage.R;
import com.photolab.vintage.util.picker.adapter.PhotoPagerAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePagerFragment extends Fragment {
    public static final String ARG_CURRENT_ITEM = "ARG_CURRENT_ITEM";
    public static final String ARG_PATH = "PATHS";
    private int currentItem = 0;
    private PhotoPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private ArrayList<String> paths;

    public static ImagePagerFragment newInstance(List<String> list, int i) {
        ImagePagerFragment imagePagerFragment = new ImagePagerFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray(ARG_PATH, (String[]) list.toArray(new String[list.size()]));
        bundle.putInt(ARG_CURRENT_ITEM, i);
        imagePagerFragment.setArguments(bundle);
        return imagePagerFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public void setPhotos(List<String> list, int i) {
        this.paths.clear();
        this.paths.addAll(list);
        this.currentItem = i;
        this.mViewPager.setCurrentItem(i);
        this.mViewPager.getAdapter().notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.paths = new ArrayList<>();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String[] stringArray = arguments.getStringArray(ARG_PATH);
            this.paths.clear();
            if (stringArray != null) {
                this.paths = new ArrayList<>(Arrays.asList(stringArray));
            }
            this.currentItem = arguments.getInt(ARG_CURRENT_ITEM);
        }
        this.mPagerAdapter = new PhotoPagerAdapter(Glide.with(this), this.paths);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.__picker_picker_fragment_image_pager, viewGroup, false);
        ViewPager viewPager = (ViewPager) viewInflate.findViewById(R.id.vp_photos);
        this.mViewPager = viewPager;
        viewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setCurrentItem(this.currentItem);
        this.mViewPager.setOffscreenPageLimit(5);
        return viewInflate;
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public ArrayList<String> getPaths() {
        return this.paths;
    }

    public ArrayList<String> getCurrentPath() {
        ArrayList<String> arrayList = new ArrayList<>();
        int currentItem = this.mViewPager.getCurrentItem();
        ArrayList<String> arrayList2 = this.paths;
        if (arrayList2 != null && arrayList2.size() > currentItem) {
            arrayList.add(this.paths.get(currentItem));
        }
        return arrayList;
    }

    public int getCurrentItem() {
        return this.mViewPager.getCurrentItem();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.paths.clear();
        this.paths = null;
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setAdapter(null);
        }
    }
}
