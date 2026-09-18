package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class WriteTree {
    private static final Predicate<UserWriteRecord> DEFAULT_FILTER = new Predicate<UserWriteRecord>() { // from class: com.google.firebase.database.core.WriteTree.2
        @Override // com.google.firebase.database.core.utilities.Predicate
        public boolean evaluate(UserWriteRecord userWriteRecord) {
            return userWriteRecord.isVisible();
        }
    };
    private CompoundWrite visibleWrites = CompoundWrite.emptyWrite();
    private List<UserWriteRecord> allWrites = new ArrayList();
    private Long lastWriteId = -1L;

    public WriteTreeRef childWrites(Path path) {
        return new WriteTreeRef(path, this);
    }

    public void addOverwrite(Path path, Node node, Long l, boolean z) {
        Utilities.hardAssert(l.longValue() > this.lastWriteId.longValue());
        this.allWrites.add(new UserWriteRecord(l.longValue(), path, node, z));
        if (z) {
            this.visibleWrites = this.visibleWrites.addWrite(path, node);
        }
        this.lastWriteId = l;
    }

    public void addMerge(Path path, CompoundWrite compoundWrite, Long l) {
        Utilities.hardAssert(l.longValue() > this.lastWriteId.longValue());
        this.allWrites.add(new UserWriteRecord(l.longValue(), path, compoundWrite));
        this.visibleWrites = this.visibleWrites.addWrites(path, compoundWrite);
        this.lastWriteId = l;
    }

    public UserWriteRecord getWrite(long j) {
        for (UserWriteRecord userWriteRecord : this.allWrites) {
            if (userWriteRecord.getWriteId() == j) {
                return userWriteRecord;
            }
        }
        return null;
    }

    public List<UserWriteRecord> purgeAllWrites() {
        ArrayList arrayList = new ArrayList(this.allWrites);
        this.visibleWrites = CompoundWrite.emptyWrite();
        this.allWrites = new ArrayList();
        return arrayList;
    }

    public boolean removeWrite(long j) {
        UserWriteRecord next;
        Iterator<UserWriteRecord> it = this.allWrites.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.getWriteId() == j) {
                break;
            }
            i++;
        }
        Utilities.hardAssert(next != null, "removeWrite called with nonexistent writeId");
        this.allWrites.remove(next);
        boolean zIsVisible = next.isVisible();
        boolean z = false;
        for (int size = this.allWrites.size() - 1; zIsVisible && size >= 0; size--) {
            UserWriteRecord userWriteRecord = this.allWrites.get(size);
            if (userWriteRecord.isVisible()) {
                if (size >= i && recordContainsPath(userWriteRecord, next.getPath())) {
                    zIsVisible = false;
                } else if (next.getPath().contains(userWriteRecord.getPath())) {
                    z = true;
                }
            }
        }
        if (!zIsVisible) {
            return false;
        }
        if (z) {
            resetTree();
            return true;
        }
        if (next.isOverwrite()) {
            this.visibleWrites = this.visibleWrites.removeWrite(next.getPath());
        } else {
            Iterator<Map.Entry<Path, Node>> it2 = next.getMerge().iterator();
            while (it2.hasNext()) {
                this.visibleWrites = this.visibleWrites.removeWrite(next.getPath().child(it2.next().getKey()));
            }
        }
        return true;
    }

    public Node getCompleteWriteData(Path path) {
        return this.visibleWrites.getCompleteNode(path);
    }

    public Node calcCompleteEventCache(Path path, Node node) {
        return calcCompleteEventCache(path, node, new ArrayList());
    }

    public Node calcCompleteEventCache(Path path, Node node, List<Long> list) {
        return calcCompleteEventCache(path, node, list, false);
    }

    public Node calcCompleteEventCache(final Path path, Node node, final List<Long> list, final boolean z) {
        if (list.isEmpty() && !z) {
            Node completeNode = this.visibleWrites.getCompleteNode(path);
            if (completeNode != null) {
                return completeNode;
            }
            CompoundWrite compoundWriteChildCompoundWrite = this.visibleWrites.childCompoundWrite(path);
            if (compoundWriteChildCompoundWrite.isEmpty()) {
                return node;
            }
            if (node == null && !compoundWriteChildCompoundWrite.hasCompleteWrite(Path.getEmptyPath())) {
                return null;
            }
            if (node == null) {
                node = EmptyNode.Empty();
            }
            return compoundWriteChildCompoundWrite.apply(node);
        }
        CompoundWrite compoundWriteChildCompoundWrite2 = this.visibleWrites.childCompoundWrite(path);
        if (!z && compoundWriteChildCompoundWrite2.isEmpty()) {
            return node;
        }
        if (!z && node == null && !compoundWriteChildCompoundWrite2.hasCompleteWrite(Path.getEmptyPath())) {
            return null;
        }
        CompoundWrite compoundWriteLayerTree = layerTree(this.allWrites, new Predicate<UserWriteRecord>() { // from class: com.google.firebase.database.core.WriteTree.1
            @Override // com.google.firebase.database.core.utilities.Predicate
            public boolean evaluate(UserWriteRecord userWriteRecord) {
                return (userWriteRecord.isVisible() || z) && !list.contains(Long.valueOf(userWriteRecord.getWriteId())) && (userWriteRecord.getPath().contains(path) || path.contains(userWriteRecord.getPath()));
            }
        }, path);
        if (node == null) {
            node = EmptyNode.Empty();
        }
        return compoundWriteLayerTree.apply(node);
    }

    public Node calcCompleteEventChildren(Path path, Node node) {
        Node nodeEmpty = EmptyNode.Empty();
        Node completeNode = this.visibleWrites.getCompleteNode(path);
        if (completeNode != null) {
            if (!completeNode.isLeafNode()) {
                for (NamedNode namedNode : completeNode) {
                    nodeEmpty = nodeEmpty.updateImmediateChild(namedNode.getName(), namedNode.getNode());
                }
            }
            return nodeEmpty;
        }
        CompoundWrite compoundWriteChildCompoundWrite = this.visibleWrites.childCompoundWrite(path);
        for (NamedNode namedNode2 : node) {
            nodeEmpty = nodeEmpty.updateImmediateChild(namedNode2.getName(), compoundWriteChildCompoundWrite.childCompoundWrite(new Path(namedNode2.getName())).apply(namedNode2.getNode()));
        }
        for (NamedNode namedNode3 : compoundWriteChildCompoundWrite.getCompleteChildren()) {
            nodeEmpty = nodeEmpty.updateImmediateChild(namedNode3.getName(), namedNode3.getNode());
        }
        return nodeEmpty;
    }

    public Node calcEventCacheAfterServerOverwrite(Path path, Path path2, Node node, Node node2) {
        Utilities.hardAssert((node == null && node2 == null) ? false : true, "Either existingEventSnap or existingServerSnap must exist");
        Path pathChild = path.child(path2);
        if (this.visibleWrites.hasCompleteWrite(pathChild)) {
            return null;
        }
        CompoundWrite compoundWriteChildCompoundWrite = this.visibleWrites.childCompoundWrite(pathChild);
        if (compoundWriteChildCompoundWrite.isEmpty()) {
            return node2.getChild(path2);
        }
        return compoundWriteChildCompoundWrite.apply(node2.getChild(path2));
    }

    public Node calcCompleteChild(Path path, ChildKey childKey, CacheNode cacheNode) {
        Path pathChild = path.child(childKey);
        Node completeNode = this.visibleWrites.getCompleteNode(pathChild);
        if (completeNode != null) {
            return completeNode;
        }
        if (cacheNode.isCompleteForChild(childKey)) {
            return this.visibleWrites.childCompoundWrite(pathChild).apply(cacheNode.getNode().getImmediateChild(childKey));
        }
        return null;
    }

    public Node shadowingWrite(Path path) {
        return this.visibleWrites.getCompleteNode(path);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022  */
    public NamedNode calcNextNodeAfterPost(Path path, Node node, NamedNode namedNode, boolean z, Index index) {
        CompoundWrite compoundWriteChildCompoundWrite = this.visibleWrites.childCompoundWrite(path);
        Node completeNode = compoundWriteChildCompoundWrite.getCompleteNode(Path.getEmptyPath());
        NamedNode namedNode2 = null;
        if (completeNode != null) {
            while (r3.hasNext()) {
                if (index.compare(namedNode, namedNode, z) <= 0) {
                }
            }
        } else if (node != null) {
            completeNode = compoundWriteChildCompoundWrite.apply(node);
            for (NamedNode namedNode3 : completeNode) {
                if (index.compare(namedNode3, namedNode, z) <= 0 && (namedNode2 == null || index.compare(namedNode3, namedNode2, z) < 0)) {
                    namedNode2 = namedNode3;
                }
            }
        }
        return namedNode2;
    }

    private boolean recordContainsPath(UserWriteRecord userWriteRecord, Path path) {
        if (userWriteRecord.isOverwrite()) {
            return userWriteRecord.getPath().contains(path);
        }
        Iterator<Map.Entry<Path, Node>> it = userWriteRecord.getMerge().iterator();
        while (it.hasNext()) {
            if (userWriteRecord.getPath().child(it.next().getKey()).contains(path)) {
                return true;
            }
        }
        return false;
    }

    private void resetTree() {
        this.visibleWrites = layerTree(this.allWrites, DEFAULT_FILTER, Path.getEmptyPath());
        if (this.allWrites.size() > 0) {
            List<UserWriteRecord> list = this.allWrites;
            this.lastWriteId = Long.valueOf(list.get(list.size() - 1).getWriteId());
        } else {
            this.lastWriteId = -1L;
        }
    }

    private static CompoundWrite layerTree(List<UserWriteRecord> list, Predicate<UserWriteRecord> predicate, Path path) {
        CompoundWrite compoundWriteEmptyWrite = CompoundWrite.emptyWrite();
        for (UserWriteRecord userWriteRecord : list) {
            if (predicate.evaluate(userWriteRecord)) {
                Path path2 = userWriteRecord.getPath();
                if (userWriteRecord.isOverwrite()) {
                    if (path.contains(path2)) {
                        compoundWriteEmptyWrite = compoundWriteEmptyWrite.addWrite(Path.getRelative(path, path2), userWriteRecord.getOverwrite());
                    } else if (path2.contains(path)) {
                        compoundWriteEmptyWrite = compoundWriteEmptyWrite.addWrite(Path.getEmptyPath(), userWriteRecord.getOverwrite().getChild(Path.getRelative(path2, path)));
                    }
                } else if (path.contains(path2)) {
                    compoundWriteEmptyWrite = compoundWriteEmptyWrite.addWrites(Path.getRelative(path, path2), userWriteRecord.getMerge());
                } else if (path2.contains(path)) {
                    Path relative = Path.getRelative(path2, path);
                    if (relative.isEmpty()) {
                        compoundWriteEmptyWrite = compoundWriteEmptyWrite.addWrites(Path.getEmptyPath(), userWriteRecord.getMerge());
                    } else {
                        Node completeNode = userWriteRecord.getMerge().getCompleteNode(relative);
                        if (completeNode != null) {
                            compoundWriteEmptyWrite = compoundWriteEmptyWrite.addWrite(Path.getEmptyPath(), completeNode);
                        }
                    }
                }
            }
        }
        return compoundWriteEmptyWrite;
    }
}
