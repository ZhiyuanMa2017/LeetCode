class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int[] preSum = new int[n];
        for (int i = 0; i < n - 1; i++) {
            preSum[i + 1] = preSum[i] + travel[i];
        }
        int gCount = 0;
        int mCount = 0;
        int pCount = 0;
        int lastM = 0;
        int lastG = 0;
        int lastP = 0;
        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'M') {
                    mCount++;
                    lastM = i;
                } else if (s.charAt(j) == 'G') {
                    gCount++;
                    lastG = i;
                } else if (s.charAt(j) == 'P') {
                    pCount++;
                    lastP = i;
                }
            }
        }
        return gCount + pCount + mCount + preSum[lastG] + preSum[lastP] + preSum[lastM];
    }
}
