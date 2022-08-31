class Solution {
    int res;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res = baseCosts[0];
        for (int baseCost : baseCosts) {
            dfs(baseCost, toppingCosts, 0, target);
        }
        return res;
    }

    private void dfs(int cur, int[] toppings, int index, int target) {
        if (Math.abs(cur - target) < Math.abs(res - target)) {
            res = cur;
        } else if (Math.abs(cur - target) == Math.abs(res - target)) {
            res = Math.min(res, cur);
        }
        if (index == toppings.length) {
            return;
        }
        if (cur > target) {
            return;
        }
        dfs(cur, toppings, index + 1, target);
        dfs(cur + toppings[index], toppings, index + 1, target);
        dfs(cur + toppings[index] * 2, toppings, index + 1, target);
    }
}
