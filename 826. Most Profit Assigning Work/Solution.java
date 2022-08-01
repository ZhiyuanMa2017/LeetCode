import java.util.Arrays;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] profitDifficulty = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] pd = new int[]{profit[i], difficulty[i]};
            profitDifficulty[i] = pd;
        }
        Arrays.sort(profitDifficulty, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        Arrays.sort(worker);
        int i = worker.length - 1;
        int j = 0;
        int res = 0;
        while (i >= 0 && j < n) {
            int can = worker[i];
            int need = profitDifficulty[j][1];
            if (can >= need) {
                res += profitDifficulty[j][0];
                i--;
            } else {
                j++;
            }
        }
        return res;
    }
}
