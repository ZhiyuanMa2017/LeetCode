class Solution {
    public int minAddToMakeValid(String s) {
        int score = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                score++;
            }
            if (s.charAt(i) == ')') {
                score--;
                if (score < 0) {
                    res++;
                    score++;
                }
            }
        }
        res += score;
        return res;
    }
}
