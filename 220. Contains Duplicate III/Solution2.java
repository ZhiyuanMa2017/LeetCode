import java.util.TreeSet;

class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            long num = nums[i];
            Long floor = set.floor(num);
            Long ceiling = set.ceiling(num);
            if (floor != null && num - floor <= t) {
                return true;
            }
            if (ceiling != null && ceiling - num <= t) {
                return true;
            }
            set.add(num);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
