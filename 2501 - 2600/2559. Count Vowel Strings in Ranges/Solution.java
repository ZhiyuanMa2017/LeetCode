class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] presum = new int[n + 1];
        for (int i = 0; i < words.length; i++) {
            if (check(words[i].charAt(0)) && check(words[i].charAt(words[i].length() - 1))) {
                presum[i + 1] = presum[i] + 1;
            } else {
                presum[i + 1] = presum[i];
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int l = q[0];
            int r = q[1];
            res[i] = presum[r + 1] - presum[l];
        }
        return res;
    }

    private boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
