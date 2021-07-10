class Solution {
    public int numDecodings(String s) {
        long mod = (long) 1000000007;
        long ending = 1;
        long ending1 = 0;
        long ending2 = 0;
        for (char c : s.toCharArray()) {
            long curEnding = 0;
            if (c == '*') {
                curEnding = ending * 9 + ending1 * 9 + ending2 * 6;
                ending1 = ending;
                ending2 = ending;
            } else {
                curEnding = (c == '0' ? 0 : ending) + ending1 + (c <= '6' ? ending2 : 0);
                ending1 = (c == '1' ? ending : 0);
                ending2 = (c == '2' ? ending : 0);
            }
            ending = curEnding % mod;
        }
        return (int) ending;
    }
}
