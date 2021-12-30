import java.util.Arrays;

class Solution {
    public int knightDialer(int n) {
        int[][] neighbors = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        int mod = 1000000007;
        int[] pre = new int[10];
        Arrays.fill(pre, 1);
        int[] cur;
        for (int i = 0; i < n - 1; i++) {
            cur = new int[10];
            for (int j = 0; j < 10; j++) {
                for (int neighbor : neighbors[j]) {
                    cur[j] = (cur[j] + pre[neighbor]) % 1000000007;
                }
            }
            pre = cur;
        }
        int sum = 0;
        for (int j = 0; j < 10; j++) {
            sum = (sum + pre[j]) % 1000000007;
        }
        return sum;
    }
}
