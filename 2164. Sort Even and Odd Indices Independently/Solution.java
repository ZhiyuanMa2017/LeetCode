import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evens.add(nums[i]);
            } else {
                odds.add(nums[i]);
            }
        }
        odds.sort((a, b) -> (b - a));
        Collections.sort(evens);
        int[] res = new int[nums.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < nums.length; k++) {
            if (k % 2 == 0) {
                res[k] = evens.get(i++);
            } else {
                res[k] = odds.get(j++);
            }
        }
        return res;
    }
}
