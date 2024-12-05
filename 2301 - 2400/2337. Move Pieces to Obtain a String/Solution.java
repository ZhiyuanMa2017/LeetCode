class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (target.charAt(j) == '_') {
                continue;
            }
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            if (i >= n) {
                return false;
            }
            if (target.charAt(j) != start.charAt(i)) {
                return false;
            }
            if (target.charAt(j) == 'L' && i < j) {
                return false;
            }
            if (target.charAt(j) == 'R' && i > j) {
                return false;
            }
            i++;
        }
        while (i < n) {
            if (start.charAt(i) != '_') {
                return false;
            }
            i++;
        }
        return true;
    }
}
