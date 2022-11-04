class Solution2 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < prev.length()) {
            int j = i;
            while (j < prev.length() && prev.charAt(i) == prev.charAt(j)) {
                j++;
            }
            sb.append(j - i).append(prev.charAt(i));
            i = j;
        }
        return sb.toString();
    }
}
