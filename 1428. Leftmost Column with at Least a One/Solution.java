import java.util.List;

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */
interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
}

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                j--;
            } else {
                i++;
            }
        }
        return j == n - 1 ? -1 : j + 1;
    }
}
