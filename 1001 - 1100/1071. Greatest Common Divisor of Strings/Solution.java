class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        int n = str1.length();
        int m = str2.length();
        StringBuilder sb = new StringBuilder(str1);
        for (int i = n; i > 0; i--) {
            if (n % i != 0 || m % i != 0) {
                sb.setLength(i - 1);
                continue;
            }
            String sb1 = sb.toString().repeat(n / i);
            if (sb1.equals(str1)) {
                String sb2 = sb.toString().repeat(m / i);
                if (sb2.equals(str2)) {
                    return sb.toString();
                }
            }
            sb.setLength(i - 1);
        }
        return "";
    }
}
