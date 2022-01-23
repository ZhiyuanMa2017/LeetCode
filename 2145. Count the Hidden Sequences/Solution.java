class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0;
        long max = 0;
        long cur = 0;
        for (int difference : differences) {
            cur += difference;
            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }
        int res = (int) (upper - lower - (max - min) + 1);
        return Math.max(res, 0);
    }
}
