class Solution {
    public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    public int[] getTable(String s) {
        int[] table = new int[s.length()];
        table[0] = 0;
        int len = 0;
        int i = 1;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                table[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = table[len - 1];
                } else {
                    table[i] = len;
                    i++;
                }
            }
        }
        return table;
    }
}
