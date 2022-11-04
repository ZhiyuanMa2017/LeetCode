class Solution2 {
    public int numberOfWays(String corridor) {
        int seats = 0;
        int plants = 0;
        long res = 1;
        int mod = 1000000007;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'P') {
                plants++;
            }
            if (corridor.charAt(i) == 'S') {
                if (seats == 2) {
                    res = res * (plants + 1) % mod;
                    seats = 1;
                    plants = 0;
                } else {
                    seats++;
                    plants = 0;
                }
            }
        }
        if (seats < 2) {
            return 0;
        }
        return (int) res;
    }
}
