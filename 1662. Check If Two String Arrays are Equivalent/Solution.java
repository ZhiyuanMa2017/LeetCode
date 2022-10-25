class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int id1 = 0;
        int id2 = 0;
        int arr1 = 0;
        int arr2 = 0;
        while (arr1 < word1.length && arr2 < word2.length) {
            if (word1[arr1].charAt(id1) != word2[arr2].charAt(id2)) {
                return false;
            }
            if (id1 == word1[arr1].length() - 1) {
                id1 = 0;
                arr1++;
            } else {
                id1++;
            }
            if (id2 == word2[arr2].length() - 1) {
                id2 = 0;
                arr2++;
            } else {
                id2++;
            }
        }
        return arr1 == word1.length && arr2 == word2.length;
    }
}
