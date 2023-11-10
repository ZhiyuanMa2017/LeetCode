class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int res = 0;
        int index = 0;
        for (int i = 0; i < rows; i++) {
            int j = 0;
            int length = sentence[index].length();
            while (j + length < cols) {
                j += length + 1;
                index++;
                if (index == n) {
                    index = 0;
                    res++;
                }
                length = sentence[index].length();
            }
        }
        return res;
    }
}
