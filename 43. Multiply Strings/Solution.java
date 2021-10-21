class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int firstNumber = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int secondNumber = num2.charAt(j) - '0';
                int product = firstNumber * secondNumber + res[i + j + 1];
                res[i + j + 1] = product % 10;
                res[i + j] += product / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
