class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int mod = n % 10;
            sum += mod;
            product *= mod;
            n /= 10;
        }
        return product - sum;
    }
}
