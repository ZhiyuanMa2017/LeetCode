import java.util.Arrays;

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Integer[] time = new Integer[plantTime.length];
        for (int i = 0; i < plantTime.length; i++) {
            time[i] = i;
        }
        Arrays.sort(time, (a, b) -> growTime[b] - growTime[a]);
        int res = 0;
        int cur = 0;
        for (Integer i : time) {
            cur += plantTime[i];
            res = Math.max(res, cur + growTime[i]);
        }
        return res;
    }
}