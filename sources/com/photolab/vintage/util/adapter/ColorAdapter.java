package com.photolab.vintage.util.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.github.pavlospt.CircleView;
import com.photolab.vintage.R;
import com.photolab.vintage.util.ColorUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ColorAdapter extends RecyclerView.Adapter<ViewHolder> {
    private boolean addNoneColor;
    private List<String> colors = ColorUtils.lstColorForBrush();
    private Context context;
    private ColorChangeListener onColorChanged;
    private int selectedColorIndex;

    public interface ColorChangeListener {
        void onChange(String str);
    }

    public ColorAdapter(Context context, ColorChangeListener colorChangeListener) {
        this.context = context;
        this.onColorChanged = colorChangeListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.color_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.color.setFillColor(Color.parseColor(this.colors.get(i)));
        viewHolder.color.setStrokeColor(Color.parseColor(this.colors.get(i)));
        if (this.selectedColorIndex == i) {
            viewHolder.color.setBackgroundColor(-1);
        } else {
            viewHolder.color.setBackgroundColor(Color.parseColor(this.colors.get(i)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.colors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleView color;

        ViewHolder(View view) {
            super(view);
            CircleView circleView = (CircleView) view.findViewById(R.id.color);
            this.color = circleView;
            circleView.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.util.adapter.ColorAdapter.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ColorAdapter.this.selectedColorIndex = ViewHolder.this.getLayoutPosition();
                    ColorAdapter.this.onColorChanged.onChange((String) ColorAdapter.this.colors.get(ColorAdapter.this.selectedColorIndex));
                    ColorAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void setSelectedColorIndex(int i) {
        this.selectedColorIndex = i;
    }
}
