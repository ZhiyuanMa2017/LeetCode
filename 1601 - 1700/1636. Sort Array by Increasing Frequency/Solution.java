import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        List<Integer> l = new ArrayList<>();
        for (int num : nums) {
            count[num + 100]++;
            l.add(num);
        }
        Comparator<Integer> c = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (count[o1 + 100] != count[o2 + 100]) {
                    return count[o1 + 100] - count[o2 + 100];
                }
                return o2 - o1;
            }
        };
        l.sort(c);
        return l.stream().mapToInt(i -> i).toArray();
    }
}
