class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[58];
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            while (!check(count)) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    private boolean check(int[] count) {
        int res = 0;
        for (int i = 0; i < 58; i++) {
            if (count[i] > 0) {
                res++;
            }
            if (res > 2) {
                return false;
            }
        }
        return true;
    }
}
