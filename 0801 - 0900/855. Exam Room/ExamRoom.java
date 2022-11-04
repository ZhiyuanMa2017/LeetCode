import java.util.TreeSet;

class ExamRoom {
    int len;
    TreeSet<Integer> treeSet;

    public ExamRoom(int n) {
        len = n;
        treeSet = new TreeSet<>();
    }

    public int seat() {
        int index = 0;
        if (treeSet.size() > 0) {
            int dis = treeSet.first();
            Integer prev = null;
            for (Integer integer : treeSet) {
                if (prev != null) {
                    int d = integer - prev;
                    d /= 2;
                    if (d > dis) {
                        dis = d;
                        index = prev + d;
                    }
                }
                prev = integer;
            }
            if (len - 1 - treeSet.last() > dis) {
                index = len - 1;
            }
        }
        treeSet.add(index);
        return index;
    }

    public void leave(int p) {
        treeSet.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
