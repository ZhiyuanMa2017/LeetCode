class Solution3 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > s.length()) {
            return 0;
        }
        int res = 0;
        int[] window = new int[26];
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (window[s.charAt(right) - 'a'] > 0) {
                window[s.charAt(left) - 'a']--;
                left++;
            }
            window[s.charAt(right) - 'a']++;
            if (right - left + 1 >= k) {
                res++;
            }
        }
        return res;
    }
}
