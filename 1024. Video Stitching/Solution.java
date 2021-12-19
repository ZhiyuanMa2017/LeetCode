class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] farthestCanReach = new int[time];
        for (int[] clip : clips) {
            int start = clip[0];
            if (start < time) {
                farthestCanReach[start] = Math.max(farthestCanReach[start], clip[1]);
            }

        }
        int index = 0;
        int curEnd = 0;
        int curFarthest = 0;
        int res = 0;
        while (index <= curEnd) {
            while (index <= curEnd) {
                curFarthest = Math.max(curFarthest, farthestCanReach[index]);
                index++;
                if (curFarthest >= time) {
                    return res + 1;
                }
            }
            if (curEnd == curFarthest) {
                return -1;
            }
            res++;
            curEnd = curFarthest;
        }
        return -1;
    }
}
