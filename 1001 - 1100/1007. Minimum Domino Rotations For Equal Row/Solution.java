class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countT = new int[7];
        int[] countB = new int[7];
        int[] same = new int[7];
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            countT[tops[i]]++;
            countB[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }

        for (int i = 1; i < 7; i++) {
            if (countT[i] + countB[i] - same[i] == n) {
                return n - Math.max(countT[i], countB[i]);
            }
        }
        return -1;
    }
}
