import java.util.Arrays;

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int rowStart = 0;
        int rowEnd = m - 1;
        int colStart = 0;
        int colEnd = n - 1;
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                if (head == null) {
                    return res;
                }
                res[rowStart][j] = head.val;
                head = head.next;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                if (head == null) {
                    return res;
                }
                res[i][colEnd] = head.val;
                head = head.next;
            }
            colEnd--;
            for (int j = colEnd; j >= colStart; j--) {
                if (head == null) {
                    return res;
                }
                res[rowEnd][j] = head.val;
                head = head.next;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                if (head == null) {
                    return res;
                }
                res[i][colStart] = head.val;
                head = head.next;
            }
            colStart++;
        }
        return res;
    }
}
