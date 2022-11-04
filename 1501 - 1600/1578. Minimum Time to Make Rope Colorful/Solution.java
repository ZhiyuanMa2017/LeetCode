class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        int cur = 0;
        int max = 0;
        int i = 0;
        while (i < colors.length()) {
            int j = i + 1;
            cur = neededTime[i];
            max = neededTime[i];
            while (j < colors.length() && colors.charAt(j) == colors.charAt(i)) {
                cur += neededTime[j];
                max = Math.max(max, neededTime[j]);
                j++;
            }
            res += cur - max;
            i = j;
        }
        return res;
    }
}
