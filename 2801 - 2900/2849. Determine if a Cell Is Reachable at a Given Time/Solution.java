class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            return t != 1;
        }
        int diffX = Math.abs(sx - fx);
        int diffY = Math.abs(sy - fy);
        int dis = Math.max(diffX, diffY);
        return dis <= t;
    }
}
