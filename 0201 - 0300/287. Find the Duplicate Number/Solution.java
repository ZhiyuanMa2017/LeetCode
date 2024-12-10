class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
//        slow = F + a
//        fast = 2(F + a) = F + a + nC
//        F + a = nC
//        a = nC - F in circle
//        fast is F away from the starting node
//        leetcode 142
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}
