import java.util.TreeSet;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : arr2) {
            treeSet.add(i);
        }
        for (int num : arr1) {
            Integer prev = treeSet.floor(num);
            Integer next = treeSet.ceiling(num);
            if (prev != null && num - prev <= d) {
                continue;
            }
            if (next != null && next - num <= d) {
                continue;
            }
            res++;
        }
        return res;
    }
}
