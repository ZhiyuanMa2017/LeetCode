import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] lastIndex = new int[n];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    if (!map.containsKey(j)) {
                        map.put(j, i);
                    } else {
                        lastIndex[map.get(j)] = i;
                    }
                    while (num % j == 0) {
                        num /= j;
                    }
                }
            }
            if (num != 1) {
                if (!map.containsKey(num)) {
                    map.put(num, i);
                } else {
                    lastIndex[map.get(num)] = i;
                }
            }
        }
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (i > last) {
                return last;
            }
            last = Math.max(last, lastIndex[i]);
        }
        return -1;
    }
}
