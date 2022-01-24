class Solution2 {
    public int numRabbits(int[] answers) {
        int[] bucket = new int[1000];
        for (int answer : answers) {
            bucket[answer]++;
        }
        int res = 0;
        for (int i = 0; i < 1000; i++) {
            res += (bucket[i] + i) / (i + 1) * (i + 1);
        }
        return res;
    }
}
