class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;
        long max = 0;
        for (int i : damage) {
            sum += i;
            max = Math.max(max, i);
        }
        int armorSubtract = (int) Math.min(max, armor);
        return sum - armorSubtract + 1;
    }
}
