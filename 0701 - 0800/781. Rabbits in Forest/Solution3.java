class Solution3 {
    public int numRabbits(int[] answers) {
        int[] bucket = new int[1000];
        int res = 0;
        for (int answer : answers) {
            if (bucket[answer] == 0) {
                res += answer + 1;
            }
            bucket[answer]++;
            if (bucket[answer] == answer + 1) {
                bucket[answer] = 0;
            }
        }
        return res;
    }
}
