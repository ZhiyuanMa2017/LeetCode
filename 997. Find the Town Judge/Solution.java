class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];
        for (int[] arr : trust) {
            score[arr[1]]++;
            score[arr[0]]--;
        }
        int res = -1;
        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                res = i;
            }
        }
        return res;
    }
}
