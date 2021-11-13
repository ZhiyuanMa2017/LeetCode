class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            if (word1.equals(wordsDict[i])) {
                index1 = i;
                if (index2 != -1) {
                    res = Math.min(res, index1 - index2);
                }
            }
            if (word2.equals(wordsDict[i])) {
                index2 = i;
                if (index1 != -1) {
                    res = Math.min(res, index2 - index1);
                }
            }
        }
        return res;
    }
}
