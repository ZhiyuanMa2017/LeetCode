import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int i = 0; i < points.length; i++) {
            int[] cur = points[i];
            int dis = cur[0] * cur[0] + cur[1] * cur[1];
            maxHeap.add(new int[]{dis, i});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = maxHeap.poll();
            res[i] = points[cur[1]];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }
}
