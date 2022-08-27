class Solution {
    public int minimumDeletions(String s) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a++;
            } else {
                b = Math.max(a, b) + 1;
            }
        }
        return s.length() - Math.max(a, b);
    }
}
