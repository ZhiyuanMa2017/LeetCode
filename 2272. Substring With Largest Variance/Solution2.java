class Solution {
    public int largestVariance(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int res = 0;
        for (char a = 'a'; a <= 'z'; a++) {
            for (char b = 'a'; b <= 'z'; b++) {
                if (a == b) {
                    continue;
                }
                if (count[a - 'a'] == 0 || count[b - 'a'] == 0) {
                    continue;
                }
                int remainA = count[a - 'a'];
                int curA = 0;
                int curB = 0;
                // A must exist
                // calculate curB - curA, so only care about the remaining A
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == a) {
                        curA++;
                        remainA--;
                    } else if (s.charAt(i) == b) {
                        curB++;
                    }
                    if (curA > 0) {
                        res = Math.max(res, curB - curA);
                    }
                    if (curB < curA && remainA > 0) {
                        curB = 0;
                        curA = 0;
                    }
                }
            }
        }
        return res;
    }
}
