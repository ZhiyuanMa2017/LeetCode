/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y]
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        return helper(reader, 0, reader.length() - 1);
    }

    private int helper(ArrayReader reader, int start, int end) {
        if (start == end) {
            return start;
        }
        int n = end - start + 1;
        int l = start;
        int r = n / 2 + l - 1;
        int x = end - n / 2 + 1;
        int y = end;
        int comp = reader.compareSub(l, r, x, y);
        if (comp > 0) {
            return helper(reader, l, r);
        } else if (comp < 0) {
            return helper(reader, x, y);
        } else {
            return r + 1;
        }
    }
}
