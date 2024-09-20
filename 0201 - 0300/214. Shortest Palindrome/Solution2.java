class Solution {
    public String shortestPalindrome(String s) {
        int base = 29;
        int mod = (int) (1e9 + 7);
        String reverse = new StringBuilder(s).reverse().toString();
        long hash1 = 0;
        long hash2 = 0;
        long power = 1;
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int val = c - 'a' + 1;
            hash1 = (hash1 * base + val) % mod;
            hash2 = (val * power + hash2) % mod;
            power = (power * base) % mod;
            if (hash1 == hash2) {
                index = i;
            }
        }
        String suffix = s.substring(index + 1);
        StringBuilder res = new StringBuilder();
        res.append(suffix).reverse().append(s);
        return res.toString();
    }
}
