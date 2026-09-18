package com.photolab.vintage.util.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.photolab.vintage.R;
import com.photolab.vintage.activity.PremiumActivity;
import com.photolab.vintage.util.SharePreferenceUtil;
import com.photolab.vintage.util.SystemUtil;
import com.photolab.vintage.util.bean.FilterConfig;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FilterAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private int eightDp;
    private List<FilterConfig> filterEffects;
    private FilterListener mFilterListener;
    private int oneDp;
    private int selectedFilterIndex = 0;

    public interface FilterListener {
        void onFilterSelected(FilterConfig filterConfig);
    }

    public FilterAdapter(Context context, FilterListener filterListener, List<FilterConfig> list) {
        this.context = context;
        this.mFilterListener = filterListener;
        this.filterEffects = list;
        this.eightDp = SystemUtil.dpToPx(context, 15);
        this.oneDp = SystemUtil.dpToPx(context, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_item, viewGroup, false));
    }

    public List<FilterConfig> getFilterEffects() {
        return this.filterEffects;
    }

    public void setSelectedFilterIndex(int i) {
        this.selectedFilterIndex = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        FilterConfig filterConfig = this.filterEffects.get(i);
        viewHolder.name.setText(filterConfig.getName());
        boolean zIsPremium = filterConfig.isPremium();
        boolean zIsPurchased = SharePreferenceUtil.isPurchased(this.context);
        if (zIsPremium && !zIsPurchased) {
            viewHolder.lock.setVisibility(0);
        } else {
            viewHolder.lock.setVisibility(8);
        }
        if (this.selectedFilterIndex == i) {
            viewHolder.check.setVisibility(0);
            viewHolder.wrap.setCardElevation(4.0f);
        } else {
            viewHolder.check.setVisibility(8);
            viewHolder.wrap.setCardElevation(2.0f);
        }
        Glide.with(this.context).load(Uri.parse(filterConfig.getAssetUrl())).centerCrop().into(viewHolder.filterView);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.wrap.getLayoutParams();
        if (filterConfig.isLastItem()) {
            marginLayoutParams.rightMargin = this.eightDp;
        } else {
            marginLayoutParams.rightMargin = this.oneDp;
        }
    }

    public void reset() {
        this.selectedFilterIndex = 0;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.filterEffects.size();
    }

    public int getSelectedFilterIndex() {
        return this.selectedFilterIndex;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView check;
        ImageView filterView;
        ImageView lock;
        TextView name;
        CardView wrap;

        ViewHolder(View view) {
            super(view);
            this.filterView = (ImageView) view.findViewById(R.id.filterView);
            this.name = (TextView) view.findViewById(R.id.name);
            this.wrap = (CardView) view.findViewById(R.id.wrap);
            this.check = (ImageView) view.findViewById(R.id.check);
            this.lock = (ImageView) view.findViewById(R.id.lock);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.util.adapter.FilterAdapter.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    final FilterConfig filterConfig = (FilterConfig) FilterAdapter.this.filterEffects.get(ViewHolder.this.getLayoutPosition());
                    if (filterConfig.isPremium() && !SharePreferenceUtil.isPurchased(FilterAdapter.this.context)) {
                        int credits = SharePreferenceUtil.getCredits(FilterAdapter.this.context);
                        if (credits > 0) {
                            new AlertDialog.Builder(FilterAdapter.this.context).setTitle("Use 1 Credit?").setMessage("This is a Premium filter. Use 1 credit to apply it? (You have " + credits + " credits)").setPositiveButton("Use Credit", new DialogInterface.OnClickListener() { // from class: com.photolab.vintage.util.adapter.FilterAdapter.ViewHolder.1.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    if (SharePreferenceUtil.deductCredit(FilterAdapter.this.context)) {
                                        Toast.makeText(FilterAdapter.this.context, "Used 1 credit. Remaining: " + SharePreferenceUtil.getCredits(FilterAdapter.this.context), 0).show();
                                        ViewHolder.this.applyFilter(filterConfig);
                                    }
                                }
                            }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).setNeutralButton("Go Premium", new DialogInterface.OnClickListener() { // from class: com.photolab.vintage.util.adapter.FilterAdapter.ViewHolder.1.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    FilterAdapter.this.context.startActivity(new Intent(FilterAdapter.this.context, (Class<?>) PremiumActivity.class));
                                }
                            }).show();
                            return;
                        }
                        new AlertDialog.Builder(FilterAdapter.this.context).setTitle("Premium Filter").setMessage("You need Premium or Credits to use this filter.").setPositiveButton("Go Premium / Buy Credits", new DialogInterface.OnClickListener() { // from class: com.photolab.vintage.util.adapter.FilterAdapter.ViewHolder.1.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FilterAdapter.this.context.startActivity(new Intent(FilterAdapter.this.context, (Class<?>) PremiumActivity.class));
                            }
                        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
                        return;
                    }
                    ViewHolder.this.applyFilter(filterConfig);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void applyFilter(FilterConfig filterConfig) {
            FilterAdapter.this.selectedFilterIndex = getLayoutPosition();
            FilterAdapter.this.mFilterListener.onFilterSelected(filterConfig);
            FilterAdapter.this.notifyDataSetChanged();
        }
    }
}
