package com.photolab.vintage.util.picker.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.photolab.vintage.util.picker.entity.Photo;
import com.photolab.vintage.util.picker.entity.PhotoDirectory;
import com.photolab.vintage.util.picker.event.Selectable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SelectableAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements Selectable {
    private static final String TAG = "SelectableAdapter";
    public int currentDirectoryIndex = 0;
    protected List<PhotoDirectory> photoDirectories = new ArrayList();
    protected List<String> selectedPhotos = new ArrayList();

    @Override // com.photolab.vintage.util.picker.event.Selectable
    public boolean isSelected(Photo photo) {
        return getSelectedPhotos().contains(photo.getPath());
    }

    @Override // com.photolab.vintage.util.picker.event.Selectable
    public void toggleSelection(Photo photo) {
        if (this.selectedPhotos.contains(photo.getPath())) {
            this.selectedPhotos.remove(photo.getPath());
        } else {
            this.selectedPhotos.add(photo.getPath());
        }
    }

    @Override // com.photolab.vintage.util.picker.event.Selectable
    public void clearSelection() {
        this.selectedPhotos.clear();
    }

    @Override // com.photolab.vintage.util.picker.event.Selectable
    public int getSelectedItemCount() {
        return this.selectedPhotos.size();
    }

    public void setCurrentDirectoryIndex(int i) {
        this.currentDirectoryIndex = i;
    }

    public List<Photo> getCurrentPhotos() {
        if (this.photoDirectories.size() <= this.currentDirectoryIndex) {
            this.currentDirectoryIndex = this.photoDirectories.size() - 1;
        }
        return this.photoDirectories.get(this.currentDirectoryIndex).getPhotos();
    }

    public List<String> getCurrentPhotoPaths() {
        ArrayList arrayList = new ArrayList(getCurrentPhotos().size());
        Iterator<Photo> it = getCurrentPhotos().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPath());
        }
        return arrayList;
    }

    public List<String> getSelectedPhotos() {
        return this.selectedPhotos;
    }
}
