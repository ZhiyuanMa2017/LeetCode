class Solution {
    public boolean winnerOfGame(String colors) {
        int a = 0;
        int b = 0;
        int i = 0;
        while (i < colors.length()) {
            int j = i;
            while (j < colors.length() && colors.charAt(i) == colors.charAt(j)) {
                j++;
            }
            if (j - i >= 3) {
                if (colors.charAt(i) == 'A') {
                    a += j - i - 2;
                } else {
                    b += j - i - 2;
                }
            }
            i = j;
        }
        return a > b;
    }
}
