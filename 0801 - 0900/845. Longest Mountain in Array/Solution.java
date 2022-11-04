class Solution {
    public int longestMountain(int[] A) {
        int start = 0;
        int result = 0;
        int end;
        while (start < A.length - 2) {
            while (start < A.length - 1 && A[start + 1] <= A[start]) {
                start += 1;
            }
            end = start;
            while (end < A.length - 1 && A[end + 1] > A[end]) {
                end += 1;
            }
            while (end < A.length - 1 && A[end + 1] < A[end]) {
                end += 1;
                result = Math.max(result, end - start + 1);

            }
            start = end;
        }
        return result;
    }
}