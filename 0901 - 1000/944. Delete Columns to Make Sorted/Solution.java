class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                char c1 = strs[j].charAt(i);
                char c2 = strs[j + 1].charAt(i);
                if (c1 > c2) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
