import java.util.Stack;

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!s.isEmpty() && nums[i] < s.peek() && s.size() + nums.length - i > k) {
                s.pop();
            }
            if (s.size() < k) {
                s.push(nums[i]);
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i > -1; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}
