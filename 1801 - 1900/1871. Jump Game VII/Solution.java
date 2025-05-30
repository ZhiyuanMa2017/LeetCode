class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] count = new int[n + 1];
        int cur = 0;
        int l = 0 + minJump;
        int r = 0 + maxJump;
        if (l < n) {
            count[l]++;
        }
        if (r + 1 < n) {
            count[r + 1]--;
        }
        for (int i = 1; i < n; i++) {
            cur += count[i];
            char c = s.charAt(i);
            if (cur > 0) {
                if (c == '0') {
                    if (i == n - 1) {
                        return true;
                    }
                    l = i + minJump;
                    r = i + maxJump;
                    if (l < n) {
                        count[l]++;
                    }
                    if (r + 1 < n) {
                        count[r + 1]--;
                    }
                }
            }
        }
        return false;
    }
}
