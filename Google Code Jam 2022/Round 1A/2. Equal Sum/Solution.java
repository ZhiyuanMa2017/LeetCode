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
        EqualSum solver = new EqualSum();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class EqualSum {
        static int MAX = 30;
        static MyScanner sc;
        static PrintWriter out;

        public void solve(int testNumber, MyScanner sc, PrintWriter out) {
            EqualSum.sc = sc;
            EqualSum.out = out;

            int N = sc.nextInt();
            long[] vals = new long[2 * N];
            for (int i = 0; i < MAX; i++) {
                vals[i] = (1L << i);
                out.print(vals[i] + " ");
            }
            for (int i = MAX; i < N; i++) {
                vals[i] = 1000000000 - i + 29;
                out.print(vals[i] + " ");
            }
            out.println();
            out.flush();
            for (int i = 0; i < N; i++) {
                vals[i + N] = sc.nextInt();
            }
            Arrays.sort(vals);
            long target = Arrays.stream(vals).sum() / 2, curSum = 0;
            IntArray cur = new IntArray();
            for (int i = 2 * N - 1; i >= 0; i--) {
                if (vals[i] + curSum <= target) {
                    curSum += vals[i];
                    cur.add((int) vals[i]);
                }
            }
            for (int i = 0; i < cur.size(); i++) {
                out.print(cur.get(i) + " ");
            }
            out.println();
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

    }

    static class IntArray {
        int[] arr;
        int size;

        public IntArray() {
            arr = new int[4];
        }

        public void add(int val) {
            if (size == arr.length) {
                arr = Arrays.copyOf(arr, 2 * arr.length);
            }
            arr[size++] = val;
        }

        public int get(int pos) {
            return arr[pos];
        }

        public int size() {
            return size;
        }

        public int[] toArray() {
            return Arrays.copyOf(arr, size);
        }

        public String toString() {
            return "IntArray " + Arrays.toString(toArray());
        }

    }
}

