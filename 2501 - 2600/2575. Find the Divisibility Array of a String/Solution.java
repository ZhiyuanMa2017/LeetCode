class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        long cur = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int num = word.charAt(i) - '0';
            cur = (cur * 10 + num) % m;
            if (cur == 0) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }
}
