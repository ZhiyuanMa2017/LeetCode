import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumOperations(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Map<Integer, Integer> twoMap = new HashMap<>();
        Map<Integer, Integer> oneMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                twoMap.put(nums[i], twoMap.getOrDefault(nums[i], 0) + 1);
            } else {
                oneMap.put(nums[i], oneMap.getOrDefault(nums[i], 0) + 1);
            }
        }
        int oneFirstKey = 0;
        int oneFirstValue = 0;
        int oneSecondKey = 0;
        int oneSecondValue = 0;
        for (Integer key : oneMap.keySet()) {
            int value = oneMap.get(key);
            if (value > oneFirstValue) {
                oneSecondKey = oneFirstKey;
                oneSecondValue = oneFirstValue;
                oneFirstKey = key;
                oneFirstValue = value;
            } else if (value > oneSecondValue) {
                oneSecondValue = value;
                oneSecondKey = key;
            }
        }
        int twoFirstKey = 0;
        int twoFirstValue = 0;
        int twoSecondKey = 0;
        int twoSecondValue = 0;
        for (Integer key : twoMap.keySet()) {
            int value = twoMap.get(key);
            if (value > twoFirstValue) {
                twoSecondKey = twoFirstKey;
                twoSecondValue = twoFirstValue;
                twoFirstKey = key;
                twoFirstValue = value;
            } else if (value > twoSecondValue) {
                twoSecondValue = value;
                twoSecondKey = key;
            }
        }
        int n = nums.length;
        int odd = 0;
        int even = 0;
        if (n % 2 == 0) {
            odd = n / 2;
            even = n / 2;
        } else {
            odd = n / 2;
            even = n / 2 + 1;
        }

        if (oneFirstKey != twoFirstKey) {
            return odd - oneFirstValue + even - twoFirstValue;
        } else {
            return Math.min(odd - oneFirstValue + even - twoSecondValue,
                    odd - oneSecondValue + even - twoFirstValue);
        }
    }
}
