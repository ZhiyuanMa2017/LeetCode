class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int curMax = releaseTimes[0];
        int n = releaseTimes.length;
        for (int i = 1; i < n; i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            if (duration > curMax || (duration == curMax && keysPressed.charAt(i) > res)) {
                res = keysPressed.charAt(i);
                curMax = duration;
            }
        }
        return res;
    }
}
