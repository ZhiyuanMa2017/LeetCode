public class Solution {
    public static void main(String[] args) {
//        int[] tablePositions = {1, 2, 4, 7};
//        int[] tableHeights = {4, 5, 7, 11};
//        int[] tablePositions = {1, 3, 7};
//        int[] tableHeights = {4, 3, 3};
        int[] tablePositions = {1, 10};
        int[] tableHeights = {1, 5};
        System.out.println(maxHeight(tablePositions, tableHeights));
    }
// https://leetcode.com/discuss/interview-question/373110/Twitter-or-OA-2019-or-New-Office-Design

    public static int maxHeight(int[] tablePositions, int[] tableHeights) {
        int res = 0;
        for (int i = 0; i < tablePositions.length - 1; i++) {
            int leftPosition = tablePositions[i];
            int rightPosition = tablePositions[i + 1];
            int posDiff = rightPosition - leftPosition - 1;
            if (posDiff < 1) {
                continue;
            }
            int lowerHeight = Math.min(tableHeights[i], tableHeights[i + 1]);
            int higherHeight = Math.max(tableHeights[i], tableHeights[i + 1]);
            if (higherHeight >= lowerHeight + posDiff) {
                res = Math.max(res, lowerHeight + posDiff);
            } else {
                int heightDiff = higherHeight - lowerHeight;
                res = Math.max(res, higherHeight + (posDiff - heightDiff + 1) / 2);
            }
        }
        return res;
    }
}
