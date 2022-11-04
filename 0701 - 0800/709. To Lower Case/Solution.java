class Solution {
    public String toLowerCase(String s) {
        char[] l = s.toCharArray();
        for (int i = 0; i < l.length; i++) {
            if (l[i] >= 'A' && l[i] <= 'Z') {
                l[i] = (char) (l[i] - 'A' + 'a');
            }
        }
        return new String(l);
    }
}
