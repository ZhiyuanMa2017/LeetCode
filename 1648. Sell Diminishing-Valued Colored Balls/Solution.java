import java.util.Arrays;

class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int n = inventory.length;
        long res = 0;
        int mod = 1000000007;
        int curIndex = n - 1;
        int curHeight = inventory[n - 1];
        int levelCount;
        while (orders > 0) {
            while (curIndex >= 0 && inventory[curIndex] == curHeight) {
                curIndex--;
            }
            levelCount = n - 1 - curIndex;
            int nextHeight = curIndex < 0 ? 0 : inventory[curIndex];
            int totalCount = (curHeight - nextHeight) * levelCount;
            if (orders >= totalCount) {
                orders -= totalCount;
                long sum = (long) (nextHeight + 1 + curHeight) * (curHeight - nextHeight) * levelCount / 2;
                res = (res + sum) % mod;
            } else {
                int rows = orders / levelCount;
                int remains = orders % levelCount;
                long rowSum = (long) (curHeight + curHeight - rows + 1) * rows * levelCount / 2;
                long remainSum = (long) remains * (curHeight - rows);
                res = (res + rowSum + remainSum) % mod;
                break;
            }
            curHeight = nextHeight;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{3, 5}, 6));
    }
}
