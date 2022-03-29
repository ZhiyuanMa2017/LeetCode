class Solution2 {
    public int findDuplicate(int[] nums) {
        boolean[] find = new boolean[nums.length];
        for (int num : nums) {
            if (find[num]) {
                return num;
            }
            find[num] = true;
        }
        return -1;
    }
}
