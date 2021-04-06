class Solution {
    public int minOperations(int n) {

        // odd 1 3 5 7 9 11 13 n = 7
        // 6 + 4 + 2 = 12  n/2 = 3 = k
        // 2 + ... + 2k
        // Sum = k * (2 + 2k) / 2 = k * (k+1)

        //even 1 3 5 7 9 11 13 15 n = 8
        // 1 + 3 + 5 + 7 = 16 n/2 = 4 = k
        // 1 + ... + (2k-1)
        // Sum = k * ( 1 + 2k -1) / 2 = k * k
        int k = n / 2;

        if (n % 2 == 0) {
            return k * k;
        } else {
            return k * (k + 1);
        }
    }
}
