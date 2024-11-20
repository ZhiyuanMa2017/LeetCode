class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] count = new int[3];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        if (count[0] < k || count[1] < k || count[2] < k) {
            return -1;
        }
        int res = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            count[c - 'a']--;
            while (count[c - 'a'] < k) {
                count[s.charAt(left) - 'a']++;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return n - res;
    }
}
