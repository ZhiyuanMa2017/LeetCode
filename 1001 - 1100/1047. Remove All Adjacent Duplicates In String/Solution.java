class Solution {
    public String removeDuplicates(String s) {
        char[] res = s.toCharArray();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            res[i] = res[j];
            if (i > 0 && res[i] == res[i - 1]) {
                i -= 2;
            }
            i++;
        }
        return new String(res, 0, i);
    }
}
