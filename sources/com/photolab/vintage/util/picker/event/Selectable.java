package com.photolab.vintage.util.picker.event;

import com.photolab.vintage.util.picker.entity.Photo;

/* JADX INFO: loaded from: classes2.dex */
public interface Selectable {
    void clearSelection();

    int getSelectedItemCount();

    boolean isSelected(Photo photo);

    void toggleSelection(Photo photo);
}
