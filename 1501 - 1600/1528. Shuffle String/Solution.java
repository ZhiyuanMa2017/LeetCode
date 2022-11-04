class Solution {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }
}
