package com.photolab.vintage.util.picker.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.photolab.vintage.R;
import com.photolab.vintage.util.picker.PhotoPicker;
import com.photolab.vintage.util.picker.adapter.PhotoGridAdapter;
import com.photolab.vintage.util.picker.adapter.PopupDirectoryListAdapter;
import com.photolab.vintage.util.picker.entity.Photo;
import com.photolab.vintage.util.picker.entity.PhotoDirectory;
import com.photolab.vintage.util.picker.utils.AndroidLifecycleUtils;
import com.photolab.vintage.util.picker.utils.ImageCaptureManager;
import com.photolab.vintage.util.picker.utils.MediaStoreHelper;
import com.photolab.vintage.util.picker.utils.PermissionsUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoPickerFragment extends Fragment {
    public static int COUNT_MAX = 4;
    private static final String EXTRA_CAMERA = "camera";
    private static final String EXTRA_COLUMN = "column";
    private static final String EXTRA_COUNT = "count";
    private static final String EXTRA_GIF = "gif";
    private static final String EXTRA_ORIGIN = "origin";
    private int SCROLL_THRESHOLD = 30;
    private ImageCaptureManager captureManager;
    int column;
    private List<PhotoDirectory> directories;
    private PopupDirectoryListAdapter listAdapter;
    private ListPopupWindow listPopupWindow;
    private RequestManager mGlideRequestManager;
    private ArrayList<String> originalPhotos;
    private PhotoGridAdapter photoGridAdapter;
    private RecyclerView recyclerView;
    private TextView tvEmptyState;

    public static PhotoPickerFragment newInstance(boolean z, boolean z2, boolean z3, int i, int i2, ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(EXTRA_CAMERA, z);
        bundle.putBoolean(EXTRA_GIF, z2);
        bundle.putBoolean(PhotoPicker.EXTRA_PREVIEW_ENABLED, z3);
        bundle.putInt("column", i);
        bundle.putInt(EXTRA_COUNT, i2);
        bundle.putStringArrayList("origin", arrayList);
        PhotoPickerFragment photoPickerFragment = new PhotoPickerFragment();
        photoPickerFragment.setArguments(bundle);
        return photoPickerFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.mGlideRequestManager = Glide.with(this);
        this.directories = new ArrayList();
        this.originalPhotos = getArguments().getStringArrayList("origin");
        this.column = getArguments().getInt("column", 3);
        boolean z = getArguments().getBoolean(EXTRA_CAMERA, true);
        boolean z2 = getArguments().getBoolean(PhotoPicker.EXTRA_PREVIEW_ENABLED, true);
        PhotoGridAdapter photoGridAdapter = new PhotoGridAdapter(getActivity(), this.mGlideRequestManager, this.directories, this.originalPhotos, this.column);
        this.photoGridAdapter = photoGridAdapter;
        photoGridAdapter.setShowCamera(z);
        this.photoGridAdapter.setPreviewEnable(z2);
        this.listAdapter = new PopupDirectoryListAdapter(this.mGlideRequestManager, this.directories);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(PhotoPicker.EXTRA_SHOW_GIF, getArguments().getBoolean(EXTRA_GIF));
        MediaStoreHelper.getPhotoDirs(getActivity(), bundle2, new MediaStoreHelper.PhotosResultCallback() { // from class: com.photolab.vintage.util.picker.fragment.PhotoPickerFragment.1
            @Override // com.photolab.vintage.util.picker.utils.MediaStoreHelper.PhotosResultCallback
            public final void onResultCallback(List list) {
                PhotoPickerFragment.this.lambda$onCreate$0$PhotoPickerFragment(list);
            }
        });
        this.captureManager = new ImageCaptureManager(getActivity());
    }

    public void lambda$onCreate$0$PhotoPickerFragment(List list) {
        this.directories.clear();
        this.directories.addAll(list);
        this.photoGridAdapter.notifyDataSetChanged();
        this.listAdapter.notifyDataSetChanged();
        adjustHeight();
        updateEmptyState();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.__picker_fragment_photo_picker, viewGroup, false);
        this.recyclerView = (RecyclerView) viewInflate.findViewById(R.id.rv_photos);
        this.tvEmptyState = (TextView) viewInflate.findViewById(R.id.tv_empty_state);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.btn_back);
        RecyclerView recyclerView = this.recyclerView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.util.picker.fragment.PhotoPickerFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoPickerFragment.this.getActivity() != null) {
                        PhotoPickerFragment.this.getActivity().onBackPressed();
                    }
                }
            });
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(this.column, 1);
        staggeredGridLayoutManager.setGapStrategy(2);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(this.photoGridAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.wrap_folder);
        final ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.directIcon);
        final TextView textView = (TextView) viewInflate.findViewById(R.id.folder);
        ListPopupWindow listPopupWindow = new ListPopupWindow(getActivity());
        this.listPopupWindow = listPopupWindow;
        listPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.photolab.vintage.util.picker.fragment.PhotoPickerFragment.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                imageView2.setImageResource(R.drawable.arrow_up);
            }
        });
        this.listPopupWindow.setWidth(-1);
        this.listPopupWindow.setAnchorView(linearLayout);
        this.listPopupWindow.setAdapter(this.listAdapter);
        this.listPopupWindow.setModal(true);
        this.listPopupWindow.setDropDownGravity(80);
        this.listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.photolab.vintage.util.picker.fragment.PhotoPickerFragment.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PhotoPickerFragment.this.listPopupWindow.dismiss();
                textView.setText(((PhotoDirectory) PhotoPickerFragment.this.directories.get(i)).getName());
                PhotoPickerFragment.this.photoGridAdapter.setCurrentDirectoryIndex(i);
                PhotoPickerFragment.this.photoGridAdapter.notifyDataSetChanged();
                PhotoPickerFragment.this.updateEmptyState();
            }
        });
        this.photoGridAdapter.setOnCameraClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.util.picker.fragment.PhotoPickerFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 33) {
                    if (PermissionsUtils.checkCameraPermission(PhotoPickerFragment.this)) {
                        PhotoPickerFragment.this.openCamera();
                    }
                } else if (PermissionsUtils.checkCameraPermission(PhotoPickerFragment.this) && PermissionsUtils.checkWriteStoragePermission(PhotoPickerFragment.this)) {
                    PhotoPickerFragment.this.openCamera();
                }
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.util.picker.fragment.PhotoPickerFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PhotoPickerFragment.this.listPopupWindow.isShowing()) {
                    PhotoPickerFragment.this.listPopupWindow.dismiss();
                    imageView2.setImageResource(R.drawable.arrow_up);
                } else {
                    if (PhotoPickerFragment.this.getActivity().isFinishing()) {
                        return;
                    }
                    PhotoPickerFragment.this.adjustHeight();
                    imageView2.setImageResource(R.drawable.arrow);
                    PhotoPickerFragment.this.listPopupWindow.show();
                }
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.photolab.vintage.util.picker.fragment.PhotoPickerFragment.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                super.onScrolled(recyclerView2, i, i2);
                if (Math.abs(i2) > PhotoPickerFragment.this.SCROLL_THRESHOLD) {
                    PhotoPickerFragment.this.mGlideRequestManager.pauseRequests();
                } else {
                    PhotoPickerFragment.this.resumeRequestsIfNotDestroyed();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                if (i == 0) {
                    PhotoPickerFragment.this.resumeRequestsIfNotDestroyed();
                }
            }
        });
        updateEmptyState();
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCamera() {
        try {
            startActivityForResult(this.captureManager.dispatchTakePictureIntent(), 1);
        } catch (ActivityNotFoundException e) {
            Log.e("PhotoPickerFragment", "No Activity Found to handle Intent", e);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            if (this.captureManager == null) {
                this.captureManager = new ImageCaptureManager(getActivity());
            }
            this.captureManager.galleryAddPic();
            if (this.directories.size() > 0) {
                String currentPhotoPath = this.captureManager.getCurrentPhotoPath();
                PhotoDirectory photoDirectory = this.directories.get(0);
                photoDirectory.getPhotos().add(0, new Photo(currentPhotoPath.hashCode(), currentPhotoPath));
                photoDirectory.setCoverPath(currentPhotoPath);
                this.photoGridAdapter.notifyDataSetChanged();
                updateEmptyState();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length <= 0 || iArr[0] != 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if ((i == 1 || i == 3) && PermissionsUtils.checkCameraPermission(this)) {
                openCamera();
                return;
            }
            return;
        }
        if ((i == 1 || i == 3) && PermissionsUtils.checkWriteStoragePermission(this) && PermissionsUtils.checkCameraPermission(this)) {
            openCamera();
        }
    }

    public PhotoGridAdapter getPhotoGridAdapter() {
        return this.photoGridAdapter;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        this.captureManager.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        this.captureManager.onRestoreInstanceState(bundle);
        super.onViewStateRestored(bundle);
    }

    public ArrayList<String> getSelectedPhotoPaths() {
        return this.photoGridAdapter.getSelectedPhotoPaths();
    }

    public void adjustHeight() {
        PopupDirectoryListAdapter popupDirectoryListAdapter = this.listAdapter;
        if (popupDirectoryListAdapter != null) {
            int count = popupDirectoryListAdapter.getCount();
            int i = COUNT_MAX;
            if (count >= i) {
                count = i;
            }
            ListPopupWindow listPopupWindow = this.listPopupWindow;
            if (listPopupWindow != null) {
                listPopupWindow.setHeight(count * getResources().getDimensionPixelOffset(R.dimen.__picker_item_directory_height));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        List<PhotoDirectory> list = this.directories;
        if (list != null) {
            for (PhotoDirectory photoDirectory : list) {
                photoDirectory.getPhotoPaths().clear();
                photoDirectory.getPhotos().clear();
                photoDirectory.setPhotos(null);
            }
            this.directories.clear();
            this.directories = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeRequestsIfNotDestroyed() {
        if (AndroidLifecycleUtils.canLoadImage(this)) {
            this.mGlideRequestManager.resumeRequests();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyState() {
        List<Photo> currentPhotos;
        if (this.tvEmptyState == null || this.recyclerView == null || this.photoGridAdapter == null) {
            return;
        }
        List<PhotoDirectory> list = this.directories;
        if (list != null && list.size() > 0 && (currentPhotos = this.photoGridAdapter.getCurrentPhotos()) != null && currentPhotos.size() > 0) {
            this.tvEmptyState.setVisibility(8);
            this.recyclerView.setVisibility(0);
        } else {
            this.tvEmptyState.setVisibility(0);
            this.recyclerView.setVisibility(8);
        }
    }
}
