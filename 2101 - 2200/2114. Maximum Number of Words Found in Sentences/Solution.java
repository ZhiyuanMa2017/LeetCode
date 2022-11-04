class Solution {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String sentence : sentences) {
            String[] parts = sentence.split(" ");
            res = Math.max(res, parts.length);
        }
        return res;
    }
}
