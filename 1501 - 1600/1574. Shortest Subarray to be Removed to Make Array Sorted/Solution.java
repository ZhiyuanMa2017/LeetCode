class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int right = n - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }
        int res = right;
        int left = 0;
        while (left < right) {
            while (right < n && arr[right] < arr[left]) {
                right++;
            }
            res = Math.min(res, right - left - 1);
            if (left == 0 || arr[left + 1] >= arr[left]) {
                left++;
            } else {
                break;
            }
        }
        return res;
    }
}
