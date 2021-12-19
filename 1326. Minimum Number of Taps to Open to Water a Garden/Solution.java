class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] jumpGamer = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            int left = Math.max(0, i - ranges[i]);
            jumpGamer[left] = Math.max(jumpGamer[left], i + ranges[i]);
        }
        int res = 0, curEnd = 0, curFarthest = 0;
        int index = 0;
        while (index <= curEnd) {
            while (index <= curEnd) {
                curFarthest = Math.max(curFarthest, jumpGamer[index]);
                index++;
                if (curFarthest >= n) {
                    return res + 1;
                }
            }
            curEnd = curFarthest;
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minTaps(5, new int[]{0, 0, 0, 0, 0, 0});
    }
}
