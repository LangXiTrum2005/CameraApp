package com.photolab.vintage.util.picker.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.google.logging.type.LogSeverity;
import com.photolab.vintage.R;
import com.photolab.vintage.util.picker.entity.PhotoDirectory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PopupDirectoryListAdapter extends BaseAdapter {
    private List<PhotoDirectory> directories;
    private RequestManager glide;

    public PopupDirectoryListAdapter(RequestManager requestManager, List<PhotoDirectory> list) {
        new ArrayList();
        this.directories = list;
        this.glide = requestManager;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.directories.size();
    }

    @Override // android.widget.Adapter
    public PhotoDirectory getItem(int i) {
        return this.directories.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.directories.get(i).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.__picker_item_directory, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.bindData(this.directories.get(i));
        return view;
    }

    private class ViewHolder {
        public ImageView ivCover;
        public TextView tvCount;
        public TextView tvName;

        public ViewHolder(View view) {
            this.ivCover = (ImageView) view.findViewById(R.id.iv_dir_cover);
            this.tvName = (TextView) view.findViewById(R.id.tv_dir_name);
            this.tvCount = (TextView) view.findViewById(R.id.tv_dir_count);
        }

        public void bindData(PhotoDirectory photoDirectory) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.dontAnimate().dontTransform().override(LogSeverity.EMERGENCY_VALUE, LogSeverity.EMERGENCY_VALUE);
            PopupDirectoryListAdapter.this.glide.setDefaultRequestOptions(requestOptions).load(photoDirectory.getCoverPath()).thumbnail(0.1f).into(this.ivCover);
            this.tvName.setText(photoDirectory.getName());
            this.tvCount.setText(photoDirectory.getPhotos().size() + "");
        }
    }
}
