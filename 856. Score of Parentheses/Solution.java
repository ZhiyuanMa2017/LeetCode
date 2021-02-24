class Solution {
    public int scoreOfParentheses(String S) {
        int layer = 0;
        int res = 0;
        for (int i = 0; i < S.toCharArray().length; i++) {
            if (S.charAt(i) == '(') {
                layer++;
            } else {
                layer--;
            }
            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') {
                res += Math.pow(2, layer);
            }
        }
        return res;
    }
}
