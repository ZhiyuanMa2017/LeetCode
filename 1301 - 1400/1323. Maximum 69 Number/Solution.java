class Solution {
    public int maximum69Number(int num) {
        int cur = num;
        int pow = 1;
        int with = 0;
        while (cur > 0) {
            int d = cur % 10;
            if (d == 6) {
                with = pow * 3;
            }
            cur /= 10;
            pow *= 10;
        }
        return num + with;
    }
}
