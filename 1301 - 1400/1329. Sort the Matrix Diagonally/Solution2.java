import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution2 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            List<Integer> l = new ArrayList<>();
            int r = i;
            int c = 0;
            while (r < m && c < n) {
                l.add(mat[r][c]);
                r++;
                c++;
            }
            Collections.sort(l);
            int index = 0;
            r = i;
            c = 0;
            while (r < m && c < n) {
                mat[r][c] = l.get(index);
                index++;
                r++;
                c++;
            }
        }
        for (int j = 1; j < n; j++) {
            List<Integer> l = new ArrayList<>();
            int r = 0;
            int c = j;
            while (r < m && c < n) {
                l.add(mat[r][c]);
                r++;
                c++;
            }
            Collections.sort(l);
            int index = 0;
            r = 0;
            c = j;
            while (r < m && c < n) {
                mat[r][c] = l.get(index);
                index++;
                r++;
                c++;
            }
        }
        return mat;
    }
}
