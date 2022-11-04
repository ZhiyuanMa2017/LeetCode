class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            } else {
                if (i == 0) {
                    if (flowerbed[1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[flowerbed.length - 2] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                } else {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                }
            }
        }
        return n <= 0;
    }
}
