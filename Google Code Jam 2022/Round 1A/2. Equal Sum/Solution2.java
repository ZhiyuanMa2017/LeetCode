import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Solution {
    // https://codingcompetitions.withgoogle.com/codejam/submissions/0000000000877ba5/00000000004ce2a0

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader2 in = new InputReader2(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        EqualSum solver = new EqualSum();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class EqualSum {
        int big = 1000000000;

        public void solve(int testNumber, InputReader2 in, OutputWriter out) {
            int n = in.nextInt();
            long sum = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < big; i *= 2) {
                set.add(i);
            }
            int ptr = 1;
            while (set.size() < n) {
                set.add(ptr++);
            }
            for (int x : set) {
                sum += x;
            }
            boolean first = true;
            for (int x : set) {
                if (!first) {
                    out.print(" ");
                }
                first = false;
                out.print(x);
            }
            out.println();
            out.flush();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                set.add(x);
                sum += x;
            }
            long goal = sum / 2;
            ArrayList<Integer> nums = new ArrayList<>(set);
            Collections.sort(nums);
            int idx = nums.size() - 1;
            ArrayList<Integer> ans = new ArrayList<>();
            while (goal > 0 && idx >= 0 && goal >= nums.get(idx)) {
                int x = nums.get(idx--);
                ans.add(x);
                goal -= x;
            }
            for (int i = 1; i <= goal; i *= 2) {
                if ((goal & i) != 0) {
                    ans.add(i);
                    goal -= i;
                }
            }
            if (goal > 0) {
                throw new RuntimeException("Goal not reached, goal = " + goal + ", nums = " + nums + ", idx = " + idx);
            }
            first = true;
            for (int x : ans) {
                if (!first) {
                    out.print(" ");
                }
                out.print(x);
                first = false;
            }
            out.println();
            out.flush();
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

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println() {
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

        public void print(int i) {
            writer.print(i);
        }

    }
}

