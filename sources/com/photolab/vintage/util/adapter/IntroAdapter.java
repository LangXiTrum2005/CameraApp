package com.photolab.vintage.util.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.photolab.vintage.R;
import com.photolab.vintage.util.bean.IntroItem;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class IntroAdapter extends RecyclerView.Adapter<IntroViewHolder> {
    private List<IntroItem> introItems;

    public IntroAdapter(List<IntroItem> list) {
        this.introItems = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public IntroViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new IntroViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_intro, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(IntroViewHolder introViewHolder, int i) {
        introViewHolder.bind(this.introItems.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.introItems.size();
    }

    class IntroViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImage;
        private TextView tvDescription;
        private TextView tvTitle;

        public IntroViewHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.tvDescription = (TextView) view.findViewById(R.id.tvDescription);
            this.ivImage = (ImageView) view.findViewById(R.id.ivImage);
        }

        public void bind(IntroItem introItem) {
            this.tvTitle.setText(introItem.getTitle());
            this.tvDescription.setText(introItem.getDescription());
            this.ivImage.setImageResource(introItem.getImageResId());
        }
    }
}
