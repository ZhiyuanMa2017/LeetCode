import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> ab = new HashMap<>();
        int res = 0;
        for (int i : A) {
            for (int j : B) {
                int k = i + j;
                ab.put(k, ab.getOrDefault(k,0) + 1);
            }
        }
        for (int i : C) {
            for (int j : D) {
                int k = i + j;
                res += ab.getOrDefault(-k,0);
            }
        }
        return res;
    }
}