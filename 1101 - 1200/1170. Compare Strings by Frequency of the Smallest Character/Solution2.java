class Solution2 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] count = new int[12];
        for (String word : words) {
            int cur = f(word);
            count[cur]++;
        }
        for (int i = 9; i > 0; i--) {
            count[i] += count[i + 1];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cur = f(queries[i]);
            res[i] = count[cur + 1];
        }
        return res;
    }

    private int f(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                return count[i];
            }
        }
        return -1;
    }
}
