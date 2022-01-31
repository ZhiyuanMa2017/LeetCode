class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = n - 1;
        int j = m - 1;
        int countS = 0;
        int countT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    countS++;
                } else {
                    if (countS > 0) {
                        countS--;
                    } else {
                        break;
                    }
                }
                i--;
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    countT++;
                } else {
                    if (countT > 0) {
                        countT--;
                    } else {
                        break;
                    }
                }
                j--;
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
