class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (char c : columnTitle.toCharArray()) {
            res *= 26;
            res += c - 'A' + 1;
        }
        return res;
    }
}
