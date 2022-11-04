import java.util.Arrays;

class Solution3 {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int n = inventory.length;
        long sum = 0;
        for (int i : inventory) {
            sum += i;
        }
        long remain = sum - orders;
        long quotient = remain / n;
        long remainder = remain % n;
        int mod = 1000000007;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (inventory[i] <= quotient) {
                remain -= inventory[i];
                quotient = remain / (n - i - 1);
                remainder = remain % (n - i - 1);
            } else {
                if (remainder != 0) {
                    quotient++;
                    res = (res + (inventory[i] + quotient + 1) * (inventory[i] - quotient) / 2) % mod;
                    remain -= quotient;
                    quotient = remain / (n - i - 1);
                    remainder = remain % (n - i - 1);
                } else {
                    remain -= quotient;
                    res = (res + (inventory[i] + quotient + 1) * (inventory[i] - quotient) / 2) % mod;
                }
            }
        }
        return (int) res;
    }
}
