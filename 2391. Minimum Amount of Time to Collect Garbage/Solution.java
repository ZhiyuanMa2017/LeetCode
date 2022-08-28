class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int[] preSum = new int[n];
        for (int i = 0; i < n - 1; i++) {
            preSum[i + 1] = preSum[i] + travel[i];
        }
        int res = 0;
        for (char c : new char[]{'M', 'P', 'G'}) {
            int time = 0;
            int last = 0;
            for (int i = 0; i < n; i++) {
                int count = cal(garbage[i], c);
                if (count > 0) {
                    time += count;
                    last = i;
                }
            }
            res += time + preSum[last];
        }
        return res;
    }

    private int cal(String s, char c) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                res++;
            }
        }
        return res;
    }
}
