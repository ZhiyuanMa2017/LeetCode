class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length();
        int m = abbr.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (Character.isLetter(abbr.charAt(j))) {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            } else {
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                int k = j;
                while (k < m && Character.isDigit(abbr.charAt(k))) {
                    k++;
                }
                int num = Integer.parseInt(abbr.substring(j, k));
                j = k;
                i += num;
                if (i > n) {
                    return false;
                }
            }
        }
        return i == n && j == m;
    }
}
