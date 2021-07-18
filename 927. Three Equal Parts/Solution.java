class Solution {
    public int[] threeEqualParts(int[] arr) {
        int countOne = 0;
        for (int i : arr) {
            countOne += i;
        }
        if (countOne == 0) {
            return new int[]{0, arr.length - 1};
        }
        if (countOne % 3 != 0) {
            return new int[]{-1, -1};
        }
        int k = countOne / 3;
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                break;
            }
        }
        int start = i;
        int countK = 0;
        for (i = 0; i < arr.length; i++) {
            countK += arr[i];
            if (countK == k + 1) {
                break;
            }
        }
        int mid = i;
        int count2K = 0;
        for (i = 0; i < arr.length; i++) {
            count2K += arr[i];
            if (count2K == 2 * k + 1) {
                break;
            }
        }
        int end = i;
        while (end < arr.length && arr[start] == arr[mid] && arr[mid] == arr[end]) {
            start++;
            mid++;
            end++;
        }
        if (end == arr.length) {
            return new int[]{start - 1, mid};
        }
        return new int[]{-1, -1};
    }
}
