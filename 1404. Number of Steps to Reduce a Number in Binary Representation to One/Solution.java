class Solution {
    public int numSteps(String s) {
        int i = s.length() - 1;
        while (s.charAt(i) == '0') {
            i--;
        }
        int need = s.length() - i - 1;
        return cal(s.substring(0, i + 1)) + need;
    }

    private int cal(String s) {
        int n = s.length();
        int countOne = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                countOne++;
            }
        }
        if (countOne == 0) {
            return n - 1;
        } else {
            int need = n - 1 - countOne + 1;
            return need + n;
        }
    }
}
