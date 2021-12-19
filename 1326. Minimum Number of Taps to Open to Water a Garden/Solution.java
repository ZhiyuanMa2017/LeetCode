class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] jumpGamer = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            int left = Math.max(0, i - ranges[i]);
            jumpGamer[left] = Math.max(jumpGamer[left], i + ranges[i]);
        }
        int res = 0, curEnd = 0, curFarest = 0;
        int index = 0;
        while (index <= curEnd) {
            while (index <= curEnd) {
                curFarest = Math.max(curFarest, jumpGamer[index]);
                index++;
                if (curFarest >= n) {
                    return res + 1;
                }
            }
            if (curEnd == curFarest) {
                return -1;
            }
            curEnd = curFarest;
            res++;
        }
        return -1;
    }
}
