import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((aa, bb) -> bb[1] - aa[1]);
        if (a > 0) {
            pq.offer(new int[]{0, a});
        }
        if (b > 0) {
            pq.offer(new int[]{1, b});
        }
        if (c > 0) {
            pq.offer(new int[]{2, c});
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) - 'a' == cur[0] && sb.charAt(sb.length() - 2) - 'a' == cur[0]) {
                if (pq.isEmpty()) {
                    break;
                }
                int[] next = pq.poll();
                sb.append((char) (next[0] + 'a'));
                next[1]--;
                if (next[1] > 0) {
                    pq.offer(next);
                }
                pq.offer(cur);
            } else {
                sb.append((char) (cur[0] + 'a'));
                cur[1]--;
                if (cur[1] > 0) {
                    pq.offer(cur);
                }
            }
        }
        return sb.toString();
    }
}
