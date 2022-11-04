class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int p1 = -1;
        int p2 = -1;
        boolean same = word1.equals(word2);
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                if (same) {
                    p1 = p2;
                    p2 = i;
                } else {
                    p1 = i;
                }
            } else if (wordsDict[i].equals(word2)) {
                p2 = i;
            }
            if (p1 >= 0 && p2 >= 0) {
                res = Math.min(res, Math.abs(p2 - p1));
            }
        }
        return res;
    }
}
