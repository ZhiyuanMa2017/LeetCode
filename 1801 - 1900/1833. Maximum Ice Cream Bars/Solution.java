import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int res = 0;
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                res++;
                coins -= costs[i];
            }
        }
        return res;
    }
}
