import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class SnapshotArray {
    List<TreeMap<Integer, Integer>> res;
    int id;

    public SnapshotArray(int length) {
        res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            res.add(new TreeMap<>());
            res.get(i).put(0, 0);
        }
        id = 0;
    }

    public void set(int index, int val) {
        res.get(index).put(id, val);
    }

    public int snap() {
        return id++;
    }

    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> treeMap = res.get(index);
        Integer key = treeMap.floorKey(snap_id);
        return treeMap.get(key);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
