class Solution {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (check(s, word)) {
                res++;
            }
        }
        return res;
    }

    boolean check(String s, String word) {
        int n = s.length();
        int m = word.length();
        int i = 0;
        int j = 0;
        int i2 = 0;
        int j2 = 0;
        while (i < n && j < m) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            while (i2 < n && s.charAt(i2) == s.charAt(i)) {
                i2++;
            }
            while (j2 < m && word.charAt(j2) == word.charAt(j)) {
                j2++;
            }
            if (i2 - i < j2 - j) {
                return false;
            }
            if (i2 - i < 3 && i2 - i != j2 - j) {
                return false;
            }
            i = i2;
            j = j2;
        }
        return i == n && j == m;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.expressiveWords("heeellooo", new String[]{"hello"}));
    }
}
