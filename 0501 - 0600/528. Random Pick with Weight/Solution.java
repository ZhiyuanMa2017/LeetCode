import java.util.Random;

class Solution {
    int[] prefixSum;
    int sum;
    Random random;

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        sum = 0;
        random = new Random();
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }
    }

    public int pickIndex() {
        int target = random.nextInt(sum) + 1;
        int l = 0;
        int h = prefixSum.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (prefixSum[mid] == target) {
                return mid;
            } else if (prefixSum[mid] < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
