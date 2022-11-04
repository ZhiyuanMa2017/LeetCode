class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >= 0) {
            arr[start] = -arr[start];
            if (arr[start] == 0) {
                return true;
            } else {
                return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
            }
        } else {
            return false;
        }
    }
}
