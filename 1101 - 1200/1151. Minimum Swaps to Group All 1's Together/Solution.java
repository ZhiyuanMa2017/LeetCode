class Solution {
    public int minSwaps(int[] data) {
        int count = 0;
        for (int num : data) {
            if (num == 1) {
                count++;
            }
        }
        if (count == 1) {
            return 0;
        }
        int cur = 0;
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (data[i] == 1) {
                cur++;
            }
        }
        max = cur;
        int left = 1;
        int right = count;
        while (right < data.length) {
            if (data[left - 1] == 1) {
                cur--;
            }
            if (data[right] == 1) {
                cur++;
            }
            max = Math.max(max, cur);
            left++;
            right++;
        }
        return count - max;
    }
}
