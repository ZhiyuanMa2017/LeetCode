class Solution3 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int res = 0;
        for (int num : time) {
            int remain = num % 60;
            if (remain == 0) {
                res += count[0];
                count[0]++;
            } else {
                res += count[60 - remain];
                count[remain]++;
            }

        }
        return res;
    }
}
