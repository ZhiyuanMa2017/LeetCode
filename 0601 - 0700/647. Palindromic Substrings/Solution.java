class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countsub(s, i, i);
            count += countsub(s, i, i + 1);
        }
        return count;
    }

    private int countsub(String s, int left, int right) {
        int thiscount = 0;
        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            thiscount++;
            left--;
            right++;
        }
        return thiscount;
    }
}
