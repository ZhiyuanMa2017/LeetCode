class Solution2 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] count = new int[1000];
        for (int[] boxType : boxTypes) {
            count[boxType[1]] += boxType[0];
        }
        int res = 0;
        int remain = truckSize;
        for (int i = 1000; i >= 0; i--) {
            if (count[i] > 0) {
                if (count[i] < remain) {
                    res += count[i] * i;
                    remain -= count[i];
                } else {
                    res += remain * i;
                    break;
                }
            }
        }
        return res;
    }
}
