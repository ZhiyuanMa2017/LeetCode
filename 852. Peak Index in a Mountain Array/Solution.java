class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else if (arr[mid] < arr[mid - 1]) {
                h = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
