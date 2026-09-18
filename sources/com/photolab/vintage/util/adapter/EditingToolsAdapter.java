package com.photolab.vintage.util.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.photolab.vintage.R;
import com.photolab.vintage.view.ToolType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EditingToolsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private OnItemSelected mOnItemSelected;
    private List<ToolModel> mToolList;
    private int selectedTool;

    public interface OnItemSelected {
        void onToolSelected(ToolType toolType);
    }

    public EditingToolsAdapter(OnItemSelected onItemSelected) {
        ArrayList arrayList = new ArrayList();
        this.mToolList = arrayList;
        this.selectedTool = -1;
        this.mOnItemSelected = onItemSelected;
        arrayList.add(new ToolModel("Filter", R.drawable.ic_filter, R.drawable.ic_filter_selected, ToolType.FILTER));
        this.mToolList.add(new ToolModel("Dust", R.drawable.ic_dust, R.drawable.ic_dust_selected, ToolType.DUST));
        this.mToolList.add(new ToolModel("Light", R.drawable.ic_light, R.drawable.ic_light_selected, ToolType.LIGHT));
        this.mToolList.add(new ToolModel("Mask", R.drawable.ic_mask, R.drawable.ic_mask_selected, ToolType.MASK));
        this.mToolList.add(new ToolModel("Gradient", R.drawable.ic_gradient, R.drawable.ic_gradient_selected, ToolType.GRADIENT));
        this.mToolList.add(new ToolModel("Adjust", R.drawable.ic_adjust, R.drawable.ic_adjust_selected, ToolType.ADJUST));
    }

    public class ToolModel {
        private int mToolIcon;
        private int mToolIconSelected;
        private String mToolName;
        private ToolType mToolType;

        ToolModel(String str, int i, int i2, ToolType toolType) {
            this.mToolName = str;
            this.mToolIcon = i;
            this.mToolType = toolType;
            this.mToolIconSelected = i2;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_editing_tools, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ToolModel toolModel = this.mToolList.get(i);
        viewHolder.txtTool.setText(toolModel.mToolName);
        if (i == this.selectedTool) {
            viewHolder.imgToolIcon.setImageResource(toolModel.mToolIconSelected);
            viewHolder.txtTool.setTextColor(Color.parseColor("#6750A4"));
            viewHolder.wrapTool.setCardBackgroundColor(Color.parseColor("#EADDFF"));
            viewHolder.wrapTool.setStrokeWidth(0);
            return;
        }
        viewHolder.imgToolIcon.setImageResource(toolModel.mToolIcon);
        viewHolder.txtTool.setTextColor(Color.parseColor("#79747E"));
        viewHolder.wrapTool.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
        viewHolder.wrapTool.setStrokeWidth(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mToolList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgToolIcon;
        TextView txtTool;
        MaterialCardView wrapTool;

        ViewHolder(View view) {
            super(view);
            this.imgToolIcon = (ImageView) view.findViewById(R.id.imgToolIcon);
            this.txtTool = (TextView) view.findViewById(R.id.txtTool);
            MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R.id.wrapTool);
            this.wrapTool = materialCardView;
            materialCardView.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.util.adapter.EditingToolsAdapter.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    EditingToolsAdapter.this.mOnItemSelected.onToolSelected(((ToolModel) EditingToolsAdapter.this.mToolList.get(ViewHolder.this.getLayoutPosition())).mToolType);
                    if (EditingToolsAdapter.this.selectedTool == ViewHolder.this.getLayoutPosition()) {
                        EditingToolsAdapter.this.selectedTool = -1;
                    } else {
                        EditingToolsAdapter.this.selectedTool = ViewHolder.this.getLayoutPosition();
                    }
                    EditingToolsAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }
}
