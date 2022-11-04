class Solution2 {
    public int nextBeautifulNumber(int n) {
        while (true) {
            n++;
            if (isBalance(n)) {
                return n;
            }
        }
    }

    private boolean isBalance(int num) {
        int[] count = new int[8];
        while (num != 0) {
            if (num % 10 > 7 || num % 10 == 0) {
                return false;
            }
            count[num % 10]++;
            num /= 10;
        }
        for (int i = 1; i <= 7; i++) {
            if (count[i] != 0 && count[i] != i) {
                return false;
            }
        }
        return true;
    }
}
