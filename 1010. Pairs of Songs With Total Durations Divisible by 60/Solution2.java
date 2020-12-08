class Solution2 {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] t = new int[60];
        for (int i : time) {
            res += t[(600 - i) % 60];
            t[i % 60] += 1;
        }
        return res;
    }
}
