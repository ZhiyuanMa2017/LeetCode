class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0;
        int j = 0;
        int ii = 0;
        int jj = 0;
        while (i < word1.length && j < word2.length) {
            if (word1[i].charAt(ii) != word2[j].charAt(jj)) {
                return false;
            }
            ii++;
            jj++;
            if (ii == word1[i].length()) {
                i++;
                ii = 0;
            }
            if (jj == word2[j].length()) {
                j++;
                jj = 0;
            }
        }
        return i == word1.length && j == word2.length;
    }
}
