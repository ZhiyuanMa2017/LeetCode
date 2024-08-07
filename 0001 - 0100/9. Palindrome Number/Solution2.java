class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int t = 0;
        while (x > t) {
            t = t * 10 + x % 10;
            x /= 10;
        }
        return x == t || x == t / 10;
    }
}
