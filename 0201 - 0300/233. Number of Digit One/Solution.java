class Solution {
    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        if (s.length() == 1) {
            return n > 1 ? 1 : 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int prefix = i > 0 ? Integer.parseInt(s.substring(0, i)) : 0;
            int suffix = i < s.length() - 1 ? Integer.parseInt(s.substring(i + 1)) : 0;
            int indexValue = s.charAt(i) - '0';
            int cur = 0;
            int suffixLen = s.length() - i - 1;
            cur += prefix * Math.pow(10, suffixLen);
            if (indexValue == 1) {
                cur += suffix + 1;
            } else if (indexValue > 1) {
                cur += Math.pow(10, suffixLen);
            }
            res += cur;
        }
        return res;
    }
}
