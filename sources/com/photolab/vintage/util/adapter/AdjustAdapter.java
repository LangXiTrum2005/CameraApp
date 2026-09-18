package com.photolab.vintage.util.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.photolab.vintage.R;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AdjustAdapter extends RecyclerView.Adapter<ViewHolder> {
    private AdjustListener adjustListener;
    private Context context;
    private List<AdjustModel> lstAdjusts;
    public String FILTER_CONFIG_TEMPLATE = "@adjust brightness {0} @adjust contrast {1} @adjust saturation {2} @vignette {3} 0.7 @adjust sharpen {4} 1 @adjust whitebalance {5} 1";
    private int selectedFilterIndex = 0;

    public AdjustAdapter(Context context, AdjustListener adjustListener) {
        this.context = context;
        this.adjustListener = adjustListener;
        init();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adjust_view, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.toolName.setText(this.lstAdjusts.get(i).name);
        if (this.selectedFilterIndex == i) {
            viewHolder.icon.setImageDrawable(this.lstAdjusts.get(i).selectedIcon);
            viewHolder.toolName.setTextColor(this.context.getResources().getColor(R.color.primary));
        } else {
            viewHolder.icon.setImageDrawable(this.lstAdjusts.get(i).icon);
            viewHolder.toolName.setTextColor(this.context.getResources().getColor(R.color.on_surface_light));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.lstAdjusts.size();
    }

    public String getFilterConfig() {
        return MessageFormat.format(this.FILTER_CONFIG_TEMPLATE, this.lstAdjusts.get(0).originValue + "", this.lstAdjusts.get(1).originValue + "", this.lstAdjusts.get(2).originValue + "", this.lstAdjusts.get(3).originValue + "", this.lstAdjusts.get(4).originValue + "", Float.valueOf(this.lstAdjusts.get(5).originValue));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView toolName;

        ViewHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(R.id.icon);
            this.toolName = (TextView) view.findViewById(R.id.tool_name);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.util.adapter.AdjustAdapter.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ViewHolder.this.lambda$new$0$AdjustAdapter$ViewHolder(view2);
                }
            });
        }

        public void lambda$new$0$AdjustAdapter$ViewHolder(View view) {
            AdjustAdapter.this.selectedFilterIndex = getLayoutPosition();
            AdjustAdapter.this.adjustListener.onAdjustSelected((AdjustModel) AdjustAdapter.this.lstAdjusts.get(AdjustAdapter.this.selectedFilterIndex));
            AdjustAdapter.this.notifyDataSetChanged();
        }
    }

    public AdjustModel getCurrentAdjustModel() {
        return this.lstAdjusts.get(this.selectedFilterIndex);
    }

    private void init() {
        ArrayList arrayList = new ArrayList();
        this.lstAdjusts = arrayList;
        arrayList.add(new AdjustModel("Brightness", "brightness", this.context.getResources().getDrawable(R.drawable.brightness), this.context.getResources().getDrawable(R.drawable.brightness_selected), -1.0f, 0.0f, 1.0f));
        this.lstAdjusts.add(new AdjustModel("Contrast", "contrast", this.context.getResources().getDrawable(R.drawable.contrast), this.context.getResources().getDrawable(R.drawable.contrast_selected), 0.5f, 1.0f, 1.5f));
        this.lstAdjusts.add(new AdjustModel("Saturation", "saturation", this.context.getResources().getDrawable(R.drawable.saturation), this.context.getResources().getDrawable(R.drawable.saturation_selected), 0.0f, 1.0f, 2.0f));
        this.lstAdjusts.add(new AdjustModel("Vignette", "vignette", this.context.getResources().getDrawable(R.drawable.vignette), this.context.getResources().getDrawable(R.drawable.vignette_selected), 0.0f, 0.6f, 0.6f));
        this.lstAdjusts.add(new AdjustModel("Sharpen", "sharpen", this.context.getResources().getDrawable(R.drawable.sharpen), this.context.getResources().getDrawable(R.drawable.sharpen_selected), 0.0f, 0.0f, 10.0f));
        this.lstAdjusts.add(new AdjustModel("Temp", "whitebalance", this.context.getResources().getDrawable(R.drawable.temperature), this.context.getResources().getDrawable(R.drawable.temperature_selected), -1.0f, 0.0f, 1.0f));
    }

    public class AdjustModel {
        String code;
        Drawable icon;
        public float maxValue;
        public float minValue;
        String name;
        public float originValue;
        Drawable selectedIcon;

        AdjustModel(String str, String str2, Drawable drawable, Drawable drawable2, float f, float f2, float f3) {
            this.name = str;
            this.code = str2;
            this.icon = drawable;
            this.minValue = f;
            this.originValue = f2;
            this.maxValue = f3;
            this.selectedIcon = drawable2;
        }
    }
}
