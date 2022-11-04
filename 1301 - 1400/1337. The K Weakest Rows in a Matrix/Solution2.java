import java.util.ArrayList;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<Integer>[] bucket = new ArrayList[101];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                count += mat[i][j];
            }
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(i);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < 101; i++) {
            if (bucket[i] == null) {
                continue;
            }
            for (Integer integer : bucket[i]) {
                res[index] = integer;
                index++;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
