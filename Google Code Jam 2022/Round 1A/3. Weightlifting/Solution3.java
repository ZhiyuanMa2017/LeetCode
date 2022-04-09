import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    // https://codingcompetitions.withgoogle.com/codejam/submissions/0000000000877ba5/000000000057c27c

    public static class Task {

        int count(int[][] X, int f, int t, int[][] dp) {
            if (dp[f][t] != -1) {
                return dp[f][t];
            }
            int n = X.length, m = X[0].length;
            int best = (int) 1e9;
            if (f == t) {
                return dp[f][t] = patternSize[f][t] * 2;
            }
            int basePattern = patternSize[f][t];
            for (int i = f + 1; i <= t; i++) {
                // [f, i - 1]
                // [i, t]
                int r1 = count(X, f, i - 1, dp);
                int r2 = count(X, i, t, dp);
                r1 -= 2 * basePattern;
                r2 -= 2 * basePattern;
                best = Math.min(best, r1 + r2 + 2 * basePattern);
            }
            return dp[f][t] = best;
        }

        int[][][] pattern;
        int[][] patternSize;

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            for (int ks = 1; ks <= T; ks++) {
                int E = sc.nextInt();
                int W = sc.nextInt();
                int[][] X = new int[E][W];
                for (int i = 0; i < E; i++) {
                    for (int j = 0; j < W; j++) {
                        X[i][j] = sc.nextInt();
                    }
                }
                pattern = new int[E][E][W];
                patternSize = new int[E][E];
                for (int i = 0; i < E; i++) {
                    int[] cnt = new int[W];
                    for (int j = 0; j < W; j++) {
                        cnt[j] = 100;
                    }
                    for (int j = i; j < E; j++) {
                        for (int k = 0; k < W; k++) {
                            pattern[i][j][k] = cnt[k] = Math.min(cnt[k], X[j][k]);
                            patternSize[i][j] += pattern[i][j][k];
                        }
                    }
                }
                int[][] dp = new int[E][E];
                for (int i = 0; i < E; i++) {
                    Arrays.fill(dp[i], -1);
                }
                pw.println("Case #" + ks + ": " + count(X, 0, E - 1, dp));
            }
        }
    }

    static long TIME_START, TIME_END;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("in.txt"));

        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("out.txt"));

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        pw.close();
        System.err.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.err.println("Time used: " + (TIME_END - TIME_START) + ".");
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}
