import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
    // https://codingcompetitions.withgoogle.com/codejam/submissions/0000000000877ba5/0000000000479cce

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Weightlifting solver = new Weightlifting();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Weightlifting {
        public void solve(int testNumber, MyScanner sc, PrintWriter out) {
            int E = sc.nextInt();
            int W = sc.nextInt();
            int[][] need = new int[E][];
            int ans = 0;
            for (int i = 0; i < E; i++) {
                need[i] = sc.nextIntArray(W);
                ans += Arrays.stream(need[i]).sum();
            }
            int[][] best = new int[E][E];
            for (int from = E - 1; from >= 0; from--) {
                best[from][from] = 0;
                int[] min = need[from].clone();
                int sum = Arrays.stream(min).sum();
                for (int to = from + 1; to < E; to++) {
                    for (int i = 0; i < W; i++) {
                        if (min[i] > need[to][i]) {
                            sum -= min[i];
                            min[i] = need[to][i];
                            sum += min[i];
                        }
                    }
                    best[from][to] = sum * (to - from);
                    for (int i = from; i <= to - 1; i++) {
                        best[from][to] = Math.max(best[from][to], best[from][i] + best[i + 1][to] + sum);
                    }
                }
            }
            ans -= best[0][E - 1];
            ans *= 2;
            out.println("Case #" + testNumber + ": " + ans);
            out.flush();
        }

    }

    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer tokenizer;

        public MyScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] nextIntArray(int n) {
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nextInt();
            }
            return ret;
        }

    }
}
