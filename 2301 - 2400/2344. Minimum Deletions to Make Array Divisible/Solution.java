import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        TreeMap<Integer, Integer> numMap = new TreeMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : numsDivide) {
            treeSet.add(i);
        }
        int res = 0;
        for (Integer num : numMap.keySet()) {
            int count = numMap.get(num);
            if (!test(num, treeSet)) {
                res += count;
            } else {
                break;
            }
        }
        if (res == nums.length) {
            return -1;
        }
        return res;
    }

    private boolean test(int num, TreeSet<Integer> treeSet) {
        for (Integer integer : treeSet) {
            if (integer % num != 0) {
                return false;
            }
        }
        return true;
    }
}
