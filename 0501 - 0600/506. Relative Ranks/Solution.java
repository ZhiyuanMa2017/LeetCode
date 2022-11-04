import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        Integer[] index = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> score[a] - score[b]);
        String[] res = new String[score.length];
        for (int i = 0; i < index.length; i++) {
            if (i == 0) {
                res[index[i]] = "Gold Medal";
            } else if (i == 1) {
                res[index[i]] = "Silver Medal";
            } else if (i == 2) {
                res[index[i]] = "Bronze Medal";
            } else {
                res[index[i]] = String.valueOf(i + 1);
            }
        }
        return res;
    }
}
