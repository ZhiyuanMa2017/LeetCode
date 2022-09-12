import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        SegmentTreeRMQ st = new SegmentTreeRMQ(100005);
        int ans = 0;
        for (int v : nums) {
            int maxlength = Math.max(0, -st.min(Math.max(v - k, 0), v)) + 1;
            ans = Math.max(ans, maxlength);
            st.update(v, -maxlength);
        }
        return ans;
    }

    class SegmentTreeRMQ {
        private final int[] vals;
        private final int H;
        private final int N;
        private final int I = Integer.MAX_VALUE;

        public SegmentTreeRMQ(int n) {
            N = n;
            int m = Integer.highestOneBit(Math.max(N - 1, 1)) << 2;
            H = m >>> 1;
            vals = new int[m];
            Arrays.fill(vals, 0, m, I);
        }

        public SegmentTreeRMQ(int[] a) {
            this(a.length);
            if (N >= 0) {
                System.arraycopy(a, 0, vals, H, N);
            }
            for (int i = H - 1; i >= 1; i--) {
                propagate(i);
            }
        }

        public void update(int pos, int x) {
            vals[H + pos] = x;
            for (int i = (H + pos) >>> 1; i >= 1; i >>>= 1) {
                propagate(i);
            }
        }

        private void propagate(int i) {
            vals[i] = Math.min(vals[2 * i], vals[2 * i + 1]);
        }

        public int min(int l, int r) {
            int min = I;
            if (l >= r) {
                return min;
            }
            l += H;
            r += H;
            for (; l < r; l >>>= 1, r >>>= 1) {
                if ((l & 1) == 1) {
                    min = Math.min(min, vals[l++]);
                }
                if ((r & 1) == 1) {
                    min = Math.min(min, vals[--r]);
                }
            }
            return min;
        }

        public int firstle(int l, int v) {
            if (l >= H) {
                return -1;
            }
            int cur = H + l;
            while (true) {
                if (vals[cur] <= v) {
                    if (cur >= H) {
                        return cur - H;
                    }
                    cur = 2 * cur;
                } else {
                    cur++;
                    if ((cur & cur - 1) == 0) {
                        return -1;
                    }
                    if ((cur & 1) == 0) {
                        cur >>>= 1;
                    }
                }
            }
        }

        public int lastle(int l, int v) {
            if (l < 0) {
                return -1;
            }
            int cur = H + l;
            while (true) {
                if (vals[cur] <= v) {
                    if (cur >= H) {
                        return cur - H;
                    }
                    cur = 2 * cur + 1;
                } else {
                    if ((cur & cur - 1) == 0) {
                        return -1;
                    }
                    cur--;
                    if ((cur & 1) == 1) {
                        cur >>>= 1;
                    }
                }
            }
        }
    }
}
