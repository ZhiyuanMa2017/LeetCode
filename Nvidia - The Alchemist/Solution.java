import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public static int maxPotion(List<Integer> ingredients) {
        int n = ingredients.size();
        if (n <= 3) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(ingredients.get(i), max);
                return max;
            }
        }
        int threeMax = Math.max(ingredients.get(0),
                Math.max(ingredients.get(1), ingredients.get(2)));
        int[] dp = new int[n];
        dp[0] = ingredients.get(0);
        dp[1] = Math.max(ingredients.get(1), dp[0]);
        dp[2] = Math.max(ingredients.get(2), dp[1]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2]);
            dp[i] = Math.max(dp[i], dp[i - 3] + ingredients.get(i));
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        List<Integer> l = Stream.of(800, 500, 400, 1, 600, 700).collect(Collectors.toList());
        int res = maxPotion(l);
        System.out.println(res);
    }
}
