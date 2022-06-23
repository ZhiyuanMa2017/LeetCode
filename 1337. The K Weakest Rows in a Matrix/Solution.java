import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] rowCount = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            rowCount[i] = cal(mat[i]);
        }
        PriorityQueue<Integer> h = new PriorityQueue<>((a, b) -> rowCount[a] == rowCount[b] ? b - a : rowCount[b] - rowCount[a]);
        for (int i = 0; i < mat.length; i++) {
            h.offer(i);
            if (h.size() > k) {
                h.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = h.poll();
        }
        return res;
    }

    private int cal(int[] row) {
        int l = 0;
        int r = row.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (row[mid] == 1) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
