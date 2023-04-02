import java.util.Arrays;

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            reward1[i] -= reward2[i];
            res += reward2[i];
        }
        Arrays.sort(reward1);
        int index = n - 1;
        while (k > 0) {
            res += reward1[index];
            index--;
            k--;
        }
        return res;
    }
}
