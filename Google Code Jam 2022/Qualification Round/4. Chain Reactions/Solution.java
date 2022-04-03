import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void solve(int t) {
        String I = scanner.nextLine();
        String D = scanner.nextLine();
        String P = scanner.nextLine();
        String[] fans = D.split(" ");
        String[] parents = P.split(" ");
        int[] factors = new int[fans.length + 1];
        int[] father = new int[parents.length + 1];
        int[] inDegree = new int[factors.length];
        for (int i = 1; i < factors.length; i++) {
            factors[i] = Integer.parseInt(fans[i - 1]);
        }
        for (int i = 1; i < father.length; i++) {
            father[i] = Integer.parseInt(parents[i - 1]);
            inDegree[father[i]]++;
        }

        long res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(new int[]{i, factors[i]});
            }
        }

        int[] count = new int[inDegree.length + 1];
        Arrays.fill(count, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int next = father[cur[0]];
            int val = cur[1];

            if (next == 0) {
                res += val;
            } else {
                inDegree[next]--;
                if (count[next] == Integer.MAX_VALUE) {
                    count[next] = val;
                } else {
                    res += Math.max(val, count[next]);
                    count[next] = Math.min(count[next], val);
                }

                if (inDegree[next] == 0) {
                    queue.offer(new int[]{next, Math.max(count[next], factors[next])});
                }
            }
        }
        print(t, String.valueOf(res));
    }


    private static void print(int t, String res) {
        System.out.println("Case #" + t + ": " + res);
    }

    public static void main(String[] args) {
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }
}
