class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int x = m;
        int y = n;
        for (int[] op : ops) {
            if (op[0] < x) {
                x = op[0];
            }
            if (op[1] < y) {
                y = op[1];
            }
        }
        return x * y;
    }
}
