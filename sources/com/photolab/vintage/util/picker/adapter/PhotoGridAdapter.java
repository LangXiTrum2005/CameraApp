package com.photolab.vintage.util.picker.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.photolab.vintage.R;
import com.photolab.vintage.util.picker.entity.Photo;
import com.photolab.vintage.util.picker.entity.PhotoDirectory;
import com.photolab.vintage.util.picker.event.OnItemCheckListener;
import com.photolab.vintage.util.picker.utils.AndroidLifecycleUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoGridAdapter extends SelectableAdapter<PhotoViewHolder> {
    private static final int COL_NUMBER_DEFAULT = 3;
    public static final int ITEM_TYPE_CAMERA = 100;
    public static final int ITEM_TYPE_PHOTO = 101;
    private int columnNumber;
    private RequestManager glide;
    private boolean hasCamera;
    private int imageSize;
    private View.OnClickListener onCameraClickListener;
    private OnItemCheckListener onItemCheckListener;
    private boolean previewEnable;

    public PhotoGridAdapter(Context context, RequestManager requestManager, List<PhotoDirectory> list) {
        this.onItemCheckListener = null;
        this.onCameraClickListener = null;
        this.hasCamera = true;
        this.previewEnable = true;
        this.columnNumber = 3;
        this.photoDirectories = list;
        this.glide = requestManager;
        setColumnNumber(context, this.columnNumber);
    }

    public PhotoGridAdapter(Context context, RequestManager requestManager, List<PhotoDirectory> list, ArrayList<String> arrayList, int i) {
        this(context, requestManager, list);
        setColumnNumber(context, i);
        this.selectedPhotos = new ArrayList();
        if (arrayList != null) {
            this.selectedPhotos.addAll(arrayList);
        }
    }

    private void setColumnNumber(Context context, int i) {
        this.columnNumber = i;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.imageSize = displayMetrics.widthPixels / i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (showCamera() && i == 0) ? 100 : 101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        PhotoViewHolder photoViewHolder = new PhotoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.__picker_item_photo, viewGroup, false));
        if (i == 100) {
            photoViewHolder.vSelected.setVisibility(8);
            photoViewHolder.ivPhoto.setScaleType(ImageView.ScaleType.CENTER);
            photoViewHolder.ivPhoto.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.util.picker.adapter.PhotoGridAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoGridAdapter.this.onCameraClickListener != null) {
                        PhotoGridAdapter.this.onCameraClickListener.onClick(view);
                    }
                }
            });
        }
        return photoViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final PhotoViewHolder photoViewHolder, int i) {
        final Photo photo;
        if (getItemViewType(i) == 101) {
            List<Photo> currentPhotos = getCurrentPhotos();
            if (showCamera()) {
                photo = currentPhotos.get(i - 1);
            } else {
                photo = currentPhotos.get(i);
            }
            if (AndroidLifecycleUtils.canLoadImage(photoViewHolder.ivPhoto.getContext())) {
                RequestOptions requestOptions = new RequestOptions();
                int i2 = this.imageSize;
                requestOptions.centerCrop().dontAnimate().override(i2, i2).placeholder(R.drawable.grey_background);
                this.glide.setDefaultRequestOptions(requestOptions).load(new File(photo.getPath())).thumbnail(0.5f).into(photoViewHolder.ivPhoto);
            }
            boolean zIsSelected = isSelected(photo);
            photoViewHolder.vSelected.setSelected(zIsSelected);
            photoViewHolder.ivPhoto.setSelected(zIsSelected);
            photoViewHolder.ivPhoto.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.util.picker.adapter.PhotoGridAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PhotoGridAdapter.this.onItemCheckListener.onItemCheck(photoViewHolder.getAdapterPosition(), photo, PhotoGridAdapter.this.getSelectedPhotos().size() + (PhotoGridAdapter.this.isSelected(photo) ? -1 : 1));
                }
            });
            return;
        }
        photoViewHolder.ivPhoto.setImageResource(R.drawable.black_border);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.photoDirectories.size() == 0 ? 0 : getCurrentPhotos().size();
        return showCamera() ? size + 1 : size;
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto;
        private View vSelected;

        public PhotoViewHolder(View view) {
            super(view);
            this.ivPhoto = (ImageView) view.findViewById(R.id.iv_photo);
            View viewFindViewById = view.findViewById(R.id.v_selected);
            this.vSelected = viewFindViewById;
            viewFindViewById.setVisibility(8);
        }
    }

    public void setOnItemCheckListener(OnItemCheckListener onItemCheckListener) {
        this.onItemCheckListener = onItemCheckListener;
    }

    public void setOnCameraClickListener(View.OnClickListener onClickListener) {
        this.onCameraClickListener = onClickListener;
    }

    public ArrayList<String> getSelectedPhotoPaths() {
        ArrayList<String> arrayList = new ArrayList<>(getSelectedItemCount());
        Iterator<String> it = this.selectedPhotos.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public void setShowCamera(boolean z) {
        this.hasCamera = z;
    }

    public void setPreviewEnable(boolean z) {
        this.previewEnable = z;
    }

    public boolean showCamera() {
        return this.hasCamera && this.currentDirectoryIndex == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(PhotoViewHolder photoViewHolder) {
        this.glide.clear(photoViewHolder.ivPhoto);
        super.onViewRecycled(photoViewHolder);
    }
}
