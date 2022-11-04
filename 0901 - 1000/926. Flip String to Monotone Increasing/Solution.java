class Solution {
    public int minFlipsMonoIncr(String s) {
        int oneLen = 0;
        int zeroLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroLen++;
            } else if (s.charAt(i) == '1') {
                oneLen = Math.max(oneLen, zeroLen) + 1;
            }
        }
        return s.length() - Math.max(oneLen, zeroLen);
    }
}
