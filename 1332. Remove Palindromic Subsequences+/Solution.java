class Solution {
    public int removePalindromeSub(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.reverse().toString().equals(s)) {
            return 1;
        } else {
            return 2;
        }
    }
}
