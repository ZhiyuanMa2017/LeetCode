class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int i = n1 - 1;
        int j = n2 - 1;
        while (i >= 0 || j >= 0 || sum != 0) {
            sum += i >= 0 ? a.charAt(i--) - '0' : 0;
            sum += j >= 0 ? b.charAt(j--) - '0' : 0;
            sb.append(sum % 2);
            sum /= 2;
        }
        return sb.reverse().toString();
    }
}
