public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res = res | (n & 1);
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(-1 << 31);
        System.out.println(Integer.toBinaryString(-1 << 31));
        System.out.println(-2147483648 << 1);
        System.out.println(Integer.toBinaryString(-2147483648 << 1));
        System.out.println(-1 << 32);
        System.out.println(Integer.toBinaryString(-1 << 32));
        System.out.println(-1 << 31 << 1);
        System.out.println(Integer.toBinaryString(-1 << 31 << 1));
    }
}
