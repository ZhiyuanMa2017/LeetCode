import java.util.Arrays;

class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        int[] count = new int[100001];
        for (int i : arr) {
            count[i]++;
        }
        Arrays.sort(count);
        int cur = 0;
        int sum = 0;
        for (int i = 100000; i >= 1; i--) {
            if (count[i] > 0) {
                cur++;
                sum += count[i];
                if (sum >= n / 2) {
                    return cur;
                }
            }
        }
        return -1;
    }
}
