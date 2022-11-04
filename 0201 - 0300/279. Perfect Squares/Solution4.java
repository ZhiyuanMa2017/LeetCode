import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution4 {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int level = 0;
        q.offer(n);
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                for (int j = 1; j * j <= num; j++) {
                    int newNum = num - j * j;
                    if (newNum == 0) {
                        return level;
                    }
                    if (!visited.contains(newNum)) {
                        visited.add(newNum);
                        q.offer(newNum);
                    }
                }
            }
        }
        return -1;
    }
}
