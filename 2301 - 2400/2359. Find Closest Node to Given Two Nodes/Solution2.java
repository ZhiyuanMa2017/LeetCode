import java.util.Arrays;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dis1 = new int[n];
        Arrays.fill(dis1, -1);
        int cur = node1;
        int d = 0;
        while (cur != -1) {
            if (dis1[cur] != -1) {
                break;
            }
            dis1[cur] = d;
            d++;
            cur = edges[cur];
        }
        int res = -1;
        int max = 2 * n;
        int[] dis2 = new int[n];
        Arrays.fill(dis2, -1);
        cur = node2;
        d = 0;
        while (cur != -1) {
            if (dis2[cur] != -1) {
                break;
            }
            dis2[cur] = d;
            if (dis1[cur] != -1) {
                int curMax = Math.max(dis2[cur], dis1[cur]);
                if (curMax < max) {
                    max = curMax;
                    res = cur;
                } else if (curMax == max) {
                    if (cur < res) {
                        res = cur;
                    }
                }
            }
            d++;
            cur = edges[cur];
        }
        return res;
    }
}
