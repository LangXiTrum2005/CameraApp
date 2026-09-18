package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TreeNode<T> {
    public Map<ChildKey, TreeNode<T>> children = new HashMap();
    public T value;

    String toString(String str) {
        String string = str + "<value>: " + this.value + "\n";
        if (this.children.isEmpty()) {
            return string + str + "<empty>";
        }
        for (Map.Entry<ChildKey, TreeNode<T>> entry : this.children.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(str);
            sb.append(entry.getKey());
            sb.append(":\n");
            sb.append(entry.getValue().toString(str + "\t"));
            sb.append("\n");
            string = sb.toString();
        }
        return string;
    }
}
