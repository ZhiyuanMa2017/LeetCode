class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < strs[0].length()) {
            char c = strs[0].charAt(index);
            for (int i = 1; i < n; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            index++;
        }
        return sb.toString();
    }
}
