import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int firstRow = 0;
        int lastRow = n - 1;
        int firstColumn = 0;
        int lastColumn = m - 1;
        while (firstRow <= lastRow && firstColumn <= lastColumn) {
            for (int j = firstColumn; j <= lastColumn; j++) {
                res.add(matrix[firstRow][j]);
            }
            firstRow++;
            for (int i = firstRow; i <= lastRow; i++) {
                res.add(matrix[i][lastColumn]);
            }
            lastColumn--;
            if (firstRow <= lastRow) {
                for (int j = lastColumn; j >= firstColumn; j--) {
                    res.add(matrix[lastRow][j]);
                }
                lastRow--;
            }
            if (lastColumn >= firstColumn) {
                for (int i = lastRow; i >= firstRow; i--) {
                    res.add(matrix[i][firstColumn]);
                }
                firstColumn++;
            }
        }
        return res;
    }
}
