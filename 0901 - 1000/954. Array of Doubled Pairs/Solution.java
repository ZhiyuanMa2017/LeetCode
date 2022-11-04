import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i : arr) {
            if (i > 0) {
                pos.add(i);
            } else if (i < 0) {
                neg.add(-i);
            }
        }
        if ((arr.length - (pos.size() + neg.size())) % 2 != 0) {
            return false;
        }
        System.out.println(check(pos));
        System.out.println(check(neg));
        return check(pos) && check(neg);

    }

    private boolean check(List<Integer> nums) {
        if (nums.size() % 2 != 0) {
            return false;
        }
        int[] bucket = new int[100001];
        for (Integer num : nums) {
            bucket[num]++;
        }
        int count = nums.size();
        for (int i = 50000; i >= 0; i--) {
            if (bucket[i] == 0) {
                continue;
            }
            if (bucket[i * 2] >= 0) {
                if (bucket[i * 2] > bucket[i]) {
                    return false;
                }
                count -= bucket[i * 2] * 2;
                bucket[i] -= bucket[i * 2];
                bucket[i * 2] = 0;
            }
        }
        return count == 0;
    }
}
