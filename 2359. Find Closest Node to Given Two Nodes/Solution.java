import java.util.Arrays;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dis1 = new int[n];
        int[] dis2 = new int[n];
        Arrays.fill(dis1, -1);
        Arrays.fill(dis2, -1);
        int cur = node1;
        int d = 0;
        while (cur != -1) {
            if (dis1[cur] != -1) {
                break;
            }
            dis1[cur] = d;
            cur = edges[cur];
            d++;
        }
        cur = node2;
        d = 0;
        while (cur != -1) {
            if (dis2[cur] != -1) {
                break;
            }
            dis2[cur] = d;
            cur = edges[cur];
            d++;
        }
        int maxDis = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (dis1[i] != -1 && dis2[i] != -1) {
                int curDis = Math.max(dis1[i], dis2[i]);
                if (curDis < maxDis) {
                    index = i;
                    maxDis = curDis;
                }
            }
        }
        return index;
    }
}
