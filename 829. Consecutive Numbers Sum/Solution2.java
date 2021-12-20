class Solution2 {
    public int consecutiveNumbersSum(int n) {
        int res = 0;
        int i = 1;
        while (n > 0) {
            res += n % i == 0 ? 1 : 0;
            n -= i;
            i++;
        }
        return res;
    }
    // 1个数时，必然有一个数可构成N
    // 2个数若要构成N，第2个数与第1个数差为1，N减掉这个1能整除2则能由商与商+1构成N
    // 3个数若要构成N，第2个数与第1个数差为1，第3个数与第1个数的差为2，N减掉1再减掉2能整除3则能由商、商+1与商+2构成N
    // 当商即第1个数小于等于0时结束
}
