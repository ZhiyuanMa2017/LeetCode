class Solution {
    public boolean nimGame(int[] piles) {
        int nimSum = 0;
        for (int pile : piles) {
            nimSum ^= pile;
        }
        return nimSum != 0;
    }
}
