import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
    // https://codingcompetitions.withgoogle.com/codejam/submissions/0000000000877ba5/00000000004ce2a0

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader2 in = new InputReader2(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Weightlifting solver = new Weightlifting();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Weightlifting {
        int[][] mat;
        int[][] dp;
        int n;
        int w;

        int solve(int start, int end) {
            if (start == end) {
                return 0;
            }
            if (dp[start][end] != -1) {
                return dp[start][end];
            }
            int[] mn = new int[w];
            for (int i = 0; i < w; i++) {
                mn[i] = 1000000;
            }
            for (int i = start; i <= end; i++) {
                for (int j = 0; j < w; j++) {
                    mn[j] = Math.min(mn[j], mat[i][j]);
                }
            }

            int ans = 1 << 29;
            for (int i = start; i < end; i++) {
                int add = 0;
                for (int j = 0; j < w; j++) {
                    add += mat[i][j] - mn[j];
                    add += mat[i + 1][j] - mn[j];
                }
                ans = Math.min(ans, solve(start, i) + solve(i + 1, end) + add);
            }
            return dp[start][end] = ans;
        }

        public void solve(int testNumber, InputReader2 in, OutputWriter out) {
            n = in.nextInt();
            w = in.nextInt();
            mat = new int[n][w];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < w; j++) {
                    mat[i][j] = in.nextInt();
                }
            }
            dp = new int[n][n];
            AUtils.deepFill(dp, -1);
            out.printf("Case #%d: %d\n", testNumber, solve(0, n - 1) + AUtils.sum(mat[0]) + AUtils.sum(mat[n - 1]));
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

    }

    static class AUtils {
        public static int sum(int[] arr) {
            return Arrays.stream(arr).reduce(0, Integer::sum);
        }

        public static void deepFill(int[][] x, int val) {
            for (int[] y : x) {
                deepFill(y, val);
            }
        }

        public static void deepFill(int[] x, int val) {
            Arrays.fill(x, val);
        }

    }

    static class InputReader2 {
        private BufferedReader in;
        private StringTokenizer st;

        public InputReader2(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

    }
}

