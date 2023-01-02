class Solution {
    public int minimumPartition(String s, int k) {
        int res = 0;
        long cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            if (cur * 10 + d > k) {
                res++;
                cur = d;
                if (cur > k) {
                    return -1;
                }
            } else {
                cur = cur * 10 + d;
            }
        }
        res++;
        return res;
    }
}
