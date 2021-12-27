import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));
        int n = boxTypes.length;
        int res = 0;
        int remain = truckSize;
        for (int i = 0; i < n; i++) {
            if (boxTypes[i][0] < remain) {
                res += boxTypes[i][0] * boxTypes[i][1];
                remain -= boxTypes[i][0];
            } else {
                res += boxTypes[i][1] * remain;
                break;
            }
        }
        return res;
    }
}
