import java.util.Stack;

class Solution2 {

    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        long res = 0;
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > (i == n ? 0 : arr[i])) {
                int mid = stack.pop();
                int before = stack.isEmpty() ? -1 : stack.peek();
                long cur = (long) arr[mid] * (mid - before) * (i - mid) % mod;
                res = (res + cur) % mod;
            }
            stack.push(i);
        }
        return (int) res;
    }
}
