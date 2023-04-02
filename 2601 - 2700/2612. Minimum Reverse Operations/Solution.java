import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] res = new int[n];
        Set<Integer> ban = new HashSet<>();
        for (int i : banned) {
            ban.add(i);
        }
        // nextPos = start + ((start + k - 1) - curPos)
        // nextPos = 2 * start + k - 1 - curPos
        TreeSet<Integer>[] sets = new TreeSet[]{new TreeSet<>(), new TreeSet<>()};
        for (int i = 0; i < n; i++) {
            if (!ban.contains(i)) {
                sets[i % 2].add(i);
            }
        }
        Arrays.fill(res, -1);
        res[p] = 0;
        sets[p % 2].remove(p);
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(p);
        // L + R = curPos + nextPos
        while (!q.isEmpty()) {
            int cur = q.poll();
            int min = Math.max(cur - (k - 1), k - 1 - cur);
            int max = Math.min(cur + k - 1, (n - k) + (n - 1) - cur);
            TreeSet<Integer> set = sets[min % 2];
            for (Integer next = set.ceiling(min); next != null && next <= max; next = set.ceiling(min)) {
                q.offer(next);
                res[next] = res[cur] + 1;
                set.remove(next);
            }
        }
        return res;
    }
}
