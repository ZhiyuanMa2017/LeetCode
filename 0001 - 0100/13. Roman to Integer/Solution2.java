class Solution {
    int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public int romanToInt(String s) {
        int n = s.length();
        int m = symbols.length;
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            int val = values[j];
            String symbol = symbols[j];
            while (i + symbol.length() <= n && s.substring(i, i + symbol.length()).equals(symbol)) {
                res += val;
                i += symbol.length();
            }
            j++;
        }
        return res;
    }
}
