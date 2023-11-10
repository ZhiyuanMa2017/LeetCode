class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int cur = 0;
        for (int i = 0; i < rows; i++) {
            cur += cols;
            while (cur > 0 && s.charAt(cur % s.length()) != ' ') {
                cur--;
            }
            cur++;
        }
        return cur / s.length();
    }
}
