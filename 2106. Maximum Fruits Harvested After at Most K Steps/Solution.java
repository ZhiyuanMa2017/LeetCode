class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int lp = 0;
        int max = 0;
        int currentAmount = 0;

        for (int i = 0; i < fruits.length; ++i) {
            currentAmount += fruits[i][1];

            while (lp <= i && getDistLeft(startPos, fruits[lp][0], fruits[i][0]) > k
                    && getDistRight(startPos, fruits[lp][0], fruits[i][0]) > k) {
                currentAmount -= fruits[lp][1];
                ++lp;
            }

            max = Math.max(max, currentAmount);
        }

        return max;
    }

    private int getDistLeft(int startPos, int first, int end) {
        return Math.abs(first - startPos) + end - first;
    }

    private int getDistRight(int startPos, int first, int end) {
        return Math.abs(end - startPos) + end - first;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxTotalFruits(new int[][]{{2, 8}, {6, 3}, {8, 6}}, 5, 4);
    }
}
