class Solution {
    public boolean checkString(String s) {
        boolean findB = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (findB) {
                    return false;
                }
            }
            if (s.charAt(i) == 'b') {
                findB = true;
            }
        }
        return true;
    }
}
