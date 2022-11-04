class Solution {
    public int minimizeXor(int num1, int num2) {
        int count = Integer.bitCount(num2);
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            if (count > 0 && (num1 & (1 << i)) > 0) {
                res |= 1 << i;
                count--;
            }
        }
        if (count > 0) {
            for (int i = 0; i < 30; i++) {
                if (count > 0 && ((res & (1 << i)) == 0)) {
                    res |= 1 << i;
                    count--;
                }
            }
        }
        return res;
    }
}
