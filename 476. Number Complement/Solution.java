class Solution {
    public int findComplement(int num) {
        int cnt = 0;
        int n = num;
        while (n > 0) {
            n = n >> 1;
            cnt++;
        }
        int mask = (1 << cnt) - 1;
        return num ^ mask;
    }
}
