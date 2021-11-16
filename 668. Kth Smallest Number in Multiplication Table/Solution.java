import java.util.Arrays;

class Solution {
    public static int findKthNumber(int m, int n, int k) {
        int l = 1;
        int h = m * n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            int count = count(mid, m, n);
            if (count < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    private static int count(int num, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(num / i, n);
        }
        return count;
    }

    public static void main(String[] args) {
        findKthNumber(42, 34, 401);
        int m = 42;
        int n = 34;
        int k = 401;
        int[] nums = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = (i + 1) * (j + 1);
                int index = i * n + j;
                nums[index] = num;
            }
        }
        Arrays.sort(nums);
        System.out.println(nums[k - 2]);
        System.out.println(nums[k - 1]);
        System.out.println(nums[k]);

    }
}
