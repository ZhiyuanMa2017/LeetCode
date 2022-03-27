class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int half = (intLength + 1) / 2;
        long min = (long) Math.pow(10, half - 1);
        long max = (long) Math.pow(10, half) - 1;
        long[] res = new long[queries.length];
        for (int i = 0; i < res.length; i++) {
            int query = queries[i];
            if (min + query - 1 > max) {
                res[i] = -1;
            } else {
                res[i] = cal(min + query - 1, intLength);
            }
        }
        return res;
    }

    private long cal(long num, int len) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        if (len % 2 == 0) {
            return Long.parseLong(sb.toString() + sb.reverse().toString());
        } else {
            return Long.parseLong(sb.toString() + sb.reverse().substring(1));
        }
    }
}
