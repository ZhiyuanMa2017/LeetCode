class Solution {
    public int fillCups(int[] amount) {
        int sum = 0;
        int max = 0;
        for (int i : amount) {
            sum += i;
            max = Math.max(max, i);
        }
        return Math.max(max, (sum + 1) / 2);
    }
}
