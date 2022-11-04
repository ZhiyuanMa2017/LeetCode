class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int ten = 0;
        while (i >= 0 || j >= 0) {
            int first = i >= 0 ? num1.charAt(i) - '0' : 0;
            int second = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = first + second + ten;
            sb.append(sum % 10);
            ten = sum / 10;
            i--;
            j--;
        }
        if (ten > 0) {
            sb.append(ten);
        }
        return sb.reverse().toString();
    }
}
