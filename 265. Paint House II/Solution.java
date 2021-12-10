class Solution {
    public int minCostII(int[][] costs) {
        int[] res = costs[0];
        int k = costs[0].length;
        int n = costs.length;

        for (int i = 1; i < n; i++) {
            int minColor = -1;
            int secondMinColor = -1;
            for (int j = 0; j < k; j++) {
                int cost = res[j];
                if (minColor == -1 || cost < res[minColor]) {
                    secondMinColor = minColor;
                    minColor = j;
                } else if (secondMinColor == -1 || cost < res[secondMinColor]) {
                    secondMinColor = j;
                }
            }
            int[] temp = new int[costs[0].length];
            for (int color = 0; color < k; color++) {
                if (color == minColor) {
                    temp[color] = res[secondMinColor] + costs[i][color];
                } else {
                    temp[color] = res[minColor] + costs[i][color];
                }
            }
            res = temp;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.length; i++) {
            min = Math.min(min, res[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostII(new int[][]{
                {10, 15, 12, 14, 18, 5}, {5, 12, 18, 13, 15, 8},
                {4, 7, 4, 2, 10, 18}, {20, 9, 9, 19, 20, 5}, {10, 15, 10, 15, 16, 20},
                {9, 6, 11, 10, 12, 11}, {7, 10, 6, 12, 20, 8}, {3, 4, 4, 18, 10, 2}}));
    }
}
