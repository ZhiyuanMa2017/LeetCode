class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int score = 0;
        int left = 0;
        while (left < s.length()) {

            int right = left;
            score += s.charAt(right) == '(' ? 1 : -1;
            right++;
            while (right < s.length() && score != 0) {
                score += s.charAt(right) == '(' ? 1 : -1;
                right++;
            }
            sb.append(s, left + 1, right - 1);
            left = right;
        }
        return sb.toString();
    }
}
