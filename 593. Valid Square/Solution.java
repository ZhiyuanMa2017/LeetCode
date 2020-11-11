import java.util.HashSet;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(getdistence(p1, p2));
        hs.add(getdistence(p1, p3));
        hs.add(getdistence(p1, p4));
        hs.add(getdistence(p2, p3));
        hs.add(getdistence(p2, p4));
        hs.add(getdistence(p3, p4));
        return hs.size() == 2 && !hs.contains(0);
    }

    public int getdistence(int[] a, int[] b) {
        return (a[1] - b[1]) * (a[1]-b[1]) + (a[0] - b[0]) * (a[0] - b[0]);
    }

}