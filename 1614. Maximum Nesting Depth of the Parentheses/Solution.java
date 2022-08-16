class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cur++;
            } else if (s.charAt(i) == ')') {
                cur--;
            }
            res = Math.max(cur, res);
        }
        return res;
    }
}
