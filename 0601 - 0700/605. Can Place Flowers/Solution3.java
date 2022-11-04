class Solution3 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0) {
                boolean before = i - 1 < 0 || flowerbed[i - 1] == 0;
                boolean after = i + 1 > len - 1 || flowerbed[i + 1] == 0;
                if (after && before) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= 0;
    }
}
