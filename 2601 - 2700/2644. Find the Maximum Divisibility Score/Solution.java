class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int index = -1;
        int count = -1;
        for (int i = 0; i < mat.length; i++) {
            int cur = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    cur++;
                }
            }
            if (cur > count) {
                index = i;
                count = cur;
            }
        }
        return new int[]{index, count};
    }
}
