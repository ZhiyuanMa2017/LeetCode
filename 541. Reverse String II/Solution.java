class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count * k <= s.length()) {
            StringBuilder cur = new StringBuilder(s.substring(count * k, Math.min((count + 1) * k, s.length())));
            if (count % 2 == 0) {
                sb.append(cur.reverse());
            } else {
                sb.append(cur);
            }
            count++;
        }
        return sb.toString();
    }
}
