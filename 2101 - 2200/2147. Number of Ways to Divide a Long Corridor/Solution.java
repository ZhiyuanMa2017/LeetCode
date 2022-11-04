class Solution {
    public int numberOfWays(String corridor) {
        int lastSeat = 0;
        long res = 1;
        int total = 0;
        int mod = 1000000007;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                total++;
                if (total > 2 && total % 2 == 1) {
                    res = res * (i - lastSeat) % mod;
                }
                lastSeat = i;

            }
        }
        return total >= 2 && total % 2 == 0 ? (int) res : 0;
    }
}
