import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        long res = 0;
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        Collections.sort(even);
        Collections.sort(odd);
        List<Integer> even2 = new ArrayList<>();
        List<Integer> odd2 = new ArrayList<>();
        for (int num : target) {
            if (num % 2 == 0) {
                even2.add(num);
            } else {
                odd2.add(num);
            }
        }
        Collections.sort(even2);
        Collections.sort(odd2);
        for (int i = 0; i < even.size(); i++) {
            if (even.get(i) > even2.get(i)) {
                res += even.get(i) - even2.get(i);
            }
        }
        for (int i = 0; i < odd.size(); i++) {
            if (odd.get(i) > odd2.get(i)) {
                res += odd.get(i) - odd2.get(i);
            }
        }
        return res / 2;
    }
}
