package com.photolab.vintage.util.picker.entity;

import android.text.TextUtils;
import com.photolab.vintage.util.picker.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PhotoDirectory implements Comparable<PhotoDirectory> {
    private String coverPath;
    private long dateAdded;
    private String id;
    private String name;
    private List<Photo> photos = new ArrayList();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoDirectory)) {
            return false;
        }
        PhotoDirectory photoDirectory = (PhotoDirectory) obj;
        boolean z = !TextUtils.isEmpty(this.id);
        boolean zIsEmpty = true ^ TextUtils.isEmpty(photoDirectory.id);
        if (z && zIsEmpty && TextUtils.equals(this.id, photoDirectory.id)) {
            return TextUtils.equals(this.name, photoDirectory.name);
        }
        return false;
    }

    public int hashCode() {
        if (!TextUtils.isEmpty(this.id)) {
            int iHashCode = this.id.hashCode();
            return TextUtils.isEmpty(this.name) ? iHashCode : (iHashCode * 31) + this.name.hashCode();
        }
        if (TextUtils.isEmpty(this.name)) {
            return 0;
        }
        return this.name.hashCode();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getCoverPath() {
        return this.coverPath;
    }

    public void setCoverPath(String str) {
        this.coverPath = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public long getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(long j) {
        this.dateAdded = j;
    }

    public List<Photo> getPhotos() {
        return this.photos;
    }

    public void setPhotos(List<Photo> list) {
        if (list != null) {
            int size = list.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Photo photo = list.get(i);
                if (photo == null || !FileUtils.fileIsExists(photo.getPath())) {
                    list.remove(i);
                } else {
                    i++;
                }
            }
            this.photos = list;
        }
    }

    public List<String> getPhotoPaths() {
        ArrayList arrayList = new ArrayList(this.photos.size());
        Iterator<Photo> it = this.photos.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPath());
        }
        return arrayList;
    }

    public void addPhoto(int i, String str) {
        if (FileUtils.fileIsExists(str)) {
            this.photos.add(new Photo(i, str));
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(PhotoDirectory photoDirectory) {
        try {
            return this.name.compareTo(photoDirectory.getName());
        } catch (Exception unused) {
            return 1;
        }
    }
}
