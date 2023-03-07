import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return -1;
        }
        if (n == 2) {
            if (gcd(nums[0], nums[1]) == 1) {
                return 0;
            } else {
                return -1;
            }
        }
        if (nums[0] == 1) {
            return 0;
        }
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    while (num % j == 0) {
                        num /= j;
                    }
                    if (!map.containsKey(j)) {
                        map.put(j, new int[]{i, i});
                    } else {
                        int[] prev = map.get(j);
                        prev[1] = i;
                    }
                }
            }
            if (num != 1) {
                if (!map.containsKey(num)) {
                    map.put(num, new int[]{i, i});
                } else {
                    int[] prev = map.get(num);
                    prev[1] = i;
                }
            }
        }
        List<int[]> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            list.add(map.get(integer));
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        int i = 0;
        int first = list.get(i)[0];
        int second = list.get(i)[1];
        while (i + 1 < list.size() && second >= list.get(i + 1)[0]) {
            second = Math.max(second, list.get(i + 1)[1]);
            i++;
        }
        if (second < n - 1) {
            return second;
        }
        return -1;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
