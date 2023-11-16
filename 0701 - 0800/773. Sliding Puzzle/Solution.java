import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int slidingPuzzle(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(sb.toString(), x, y));
        int step = 0;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.cur.equals(target)) {
                    return step;
                }
                x = node.i;
                y = node.j;
                for (int p = 0; p < 4; p++) {
                    int dx = x + dirs[p];
                    int dy = y + dirs[p + 1];
                    if (dx >= 0 && dx < m && dy >= 0 && dy < n) {
                        char[] chars = node.cur.toCharArray();
                        int index1 = x * n + y;
                        int index2 = dx * n + dy;
                        char tmp = chars[index1];
                        chars[index1] = chars[index2];
                        chars[index2] = tmp;
                        String next = new String(chars);
                        if (!visited.contains(next)) {
                            queue.offer(new Node(next, dx, dy));
                            visited.add(next);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    class Node {
        String cur;
        int i;
        int j;

        Node(String s, int x, int y) {
            cur = s;
            i = x;
            j = y;
        }
    }
}
