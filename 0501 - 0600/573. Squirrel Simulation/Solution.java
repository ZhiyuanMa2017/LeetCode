class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int n = nuts.length;
        int total = 0;
        int sDis = 0;
        int diff = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int treeDis = distance(tree[0], tree[1], nuts[i][0], nuts[i][1]);
            total += treeDis * 2;
            sDis = distance(squirrel[0], squirrel[1], nuts[i][0], nuts[i][1]);
            diff = Math.max(diff, treeDis - sDis);
        }
        return total - diff;
    }

    private int distance(int x, int y, int a, int b) {
        return Math.abs(x - a) + Math.abs(y - b);
    }
}
