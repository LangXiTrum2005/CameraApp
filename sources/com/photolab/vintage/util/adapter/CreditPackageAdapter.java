package com.photolab.vintage.util.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.photolab.vintage.R;
import com.photolab.vintage.util.bean.CreditPackageConfig;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CreditPackageAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private OnPackageSelectedListener listener;
    private List<CreditPackageConfig> packages;
    private String selectedPackageId;

    public interface OnPackageSelectedListener {
        void onPackageSelected(CreditPackageConfig creditPackageConfig);
    }

    public CreditPackageAdapter(Context context, List<CreditPackageConfig> list, OnPackageSelectedListener onPackageSelectedListener) {
        this.context = context;
        this.packages = list;
        this.listener = onPackageSelectedListener;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (CreditPackageConfig creditPackageConfig : list) {
            if (creditPackageConfig.isBestValue()) {
                this.selectedPackageId = creditPackageConfig.getId();
                break;
            }
        }
        if (this.selectedPackageId == null) {
            this.selectedPackageId = list.get(0).getId();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_credit_package, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        CreditPackageConfig creditPackageConfig = this.packages.get(i);
        boolean zEquals = creditPackageConfig.getId().equals(this.selectedPackageId);
        viewHolder.tvTitle.setText(creditPackageConfig.getTitle());
        viewHolder.tvPrice.setText(creditPackageConfig.getPrice());
        if ("star".equals(creditPackageConfig.getIconType())) {
            viewHolder.ivIcon.setImageResource(R.drawable.star_icon);
            viewHolder.ivIcon.setColorFilter(Color.parseColor("#D461FF"));
        } else if ("filter".equals(creditPackageConfig.getIconType()) || "diamond".equals(creditPackageConfig.getIconType())) {
            viewHolder.ivIcon.setImageResource(R.drawable.ic_filter);
            viewHolder.ivIcon.setColorFilter(Color.parseColor("#61AFFF"));
        } else {
            viewHolder.ivIcon.setImageResource(R.drawable.ic_none);
            viewHolder.ivIcon.setColorFilter(Color.parseColor("#7B61FF"));
        }
        if (zEquals) {
            viewHolder.cardContainer.setBackgroundResource(R.drawable.bg_card_premium_selected);
            viewHolder.btnSelect.setBackgroundResource(R.drawable.bg_premium_gold_gradient);
            viewHolder.btnSelect.setBackgroundTintList(null);
            viewHolder.tvSelectText.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            viewHolder.tvBestValue.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            viewHolder.cardContainer.setBackgroundResource(R.drawable.bg_card_premium_normal);
            viewHolder.btnSelect.setBackgroundResource(R.drawable.bg_card_premium_normal);
            viewHolder.btnSelect.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#333333")));
            viewHolder.tvSelectText.setTextColor(Color.parseColor("#FFC107"));
            viewHolder.tvBestValue.setTextColor(Color.parseColor("#FFC107"));
        }
        if (creditPackageConfig.isBestValue()) {
            viewHolder.tvBestValue.setVisibility(0);
        } else {
            viewHolder.tvBestValue.setVisibility(8);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.photolab.vintage.util.adapter.CreditPackageAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i2 = i;
                if (i2 == -1 || i2 >= CreditPackageAdapter.this.packages.size()) {
                    return;
                }
                CreditPackageConfig creditPackageConfig2 = (CreditPackageConfig) CreditPackageAdapter.this.packages.get(i);
                CreditPackageAdapter.this.selectedPackageId = creditPackageConfig2.getId();
                CreditPackageAdapter.this.notifyDataSetChanged();
                if (CreditPackageAdapter.this.listener != null) {
                    CreditPackageAdapter.this.listener.onPackageSelected(creditPackageConfig2);
                }
            }
        };
        viewHolder.itemView.setOnClickListener(onClickListener);
        viewHolder.cardContainer.setOnClickListener(onClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<CreditPackageConfig> list = this.packages;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setSelectedPosition(int i) {
        List<CreditPackageConfig> list = this.packages;
        if (list == null || i < 0 || i >= list.size()) {
            return;
        }
        this.selectedPackageId = this.packages.get(i).getId();
        notifyDataSetChanged();
    }

    public void updateData(List<CreditPackageConfig> list) {
        this.packages = list;
        if (this.selectedPackageId == null && !list.isEmpty()) {
            this.selectedPackageId = this.packages.get(0).getId();
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout btnSelect;
        LinearLayout cardContainer;
        ImageView ivIcon;
        TextView tvBestValue;
        TextView tvPrice;
        TextView tvSelectText;
        TextView tvTitle;

        public ViewHolder(View view) {
            super(view);
            this.cardContainer = (LinearLayout) view.findViewById(R.id.cardContainer);
            this.ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.tvPrice = (TextView) view.findViewById(R.id.tvPrice);
            this.btnSelect = (LinearLayout) view.findViewById(R.id.btnSelect);
            this.tvBestValue = (TextView) view.findViewById(R.id.tvBestValue);
            this.tvSelectText = (TextView) view.findViewById(R.id.tvSelectText);
        }
    }
}
