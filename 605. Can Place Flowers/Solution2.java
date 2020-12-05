class Solution2 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        int cnt = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                cnt++;
            } else {
                res += (cnt - 1) / 2;
                cnt = 0;
            }
        }
        res += cnt / 2;
        return res >= n;
    }
}
