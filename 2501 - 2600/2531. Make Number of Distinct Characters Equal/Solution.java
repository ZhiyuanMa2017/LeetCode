class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int one = 0;
        int two = 0;
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0) {
                one++;
            }
            if (count2[i] > 0) {
                two++;
            }
        }
        int size1 = one;
        int size2 = two;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (count1[i] > 0 && count2[j] > 0) {
                    if (i == j) {
                        if (one == two) {
                            return true;
                        } else {
                            continue;
                        }
                    }
                    if (count1[i] == 1) {
                        size1--;
                    }
                    if (count2[j] == 1) {
                        size2--;
                    }
                    if (count2[i] == 0) {
                        size2++;
                    }
                    if (count1[j] == 0) {
                        size1++;
                    }
                    if (size1 == size2) {
                        return true;
                    }
                    size1 = one;
                    size2 = two;
                }
            }
        }
        return false;
    }
}
