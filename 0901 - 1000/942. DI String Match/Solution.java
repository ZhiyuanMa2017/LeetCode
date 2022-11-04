class Solution {
    public int[] diStringMatch(String s) {
        int cur = 0;
        int[] res = new int[s.length() + 1];
        int min = 0;
        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'I') {
                max++;
                res[i] = max;
            } else {
                min--;
                res[i] = min;
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i] -= min;
        }
        return res;
    }
}
