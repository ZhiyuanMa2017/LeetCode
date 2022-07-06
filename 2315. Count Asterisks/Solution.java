class Solution {
    public int countAsterisks(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                count++;
            } else if (count % 2 == 0 && s.charAt(i) == '*') {
                res++;
            }
        }
        return res;
    }
}
