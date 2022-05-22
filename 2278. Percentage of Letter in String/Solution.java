class Solution {
    public int percentageLetter(String s, char letter) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                res++;
            }
        }
        return res * 100 / s.length();
    }
}
