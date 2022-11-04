class Solution2 {
    Integer[] memo;

    public long coutPairs(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int val;
        long result = 0;
        int[] arr = new int[max + 1];
        memo = new Integer[k + 1];
        for (int num : nums) {
            arr[num]++;
        }
        for (int num : nums) {
            val = k / gcd(num, k);
            result += num % val == 0 ? -1 : 0;
            result += getCount(val, arr);
        }
        return result / 2;
    }

    private int getCount(int val, int[] arr) {
        if (memo[val] != null) {
            return memo[val];
        }
        int count = 0;
        for (int i = val; i < arr.length; i += val) {
            count += arr[i];
        }
        memo[val] = count;
        return count;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
