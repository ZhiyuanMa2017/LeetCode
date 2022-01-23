class Solution2 {
    public String minWindow(String s, String t) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int minLeft = 0;
        int res = s.length() + 1;
        int[] counter = new int[128];
        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i)]++;
        }
        int total = t.length();
        while (r < n) {
            char c = s.charAt(r);
            if (counter[c] > 0) {
                total--;
            }
            counter[c]--;
            if (total == 0) {
                while (l < r && counter[s.charAt(l)] < 0) {
                    counter[s.charAt(l)]++;
                    l++;
                }
                if (r - l + 1 < res) {
                    minLeft = l;
                    res = r - l + 1;
                }
                counter[s.charAt(l)]++;
                l++;
                total++;
            }
            r++;
        }
        return res == s.length() + 1 ? "" : s.substring(minLeft, minLeft + res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println('A' - 'a');
        System.out.println(Integer.valueOf('A'));
    }
}
