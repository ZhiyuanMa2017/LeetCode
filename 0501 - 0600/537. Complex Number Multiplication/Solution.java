class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) == '+') {
                index1 = i;
                break;
            }
        }
        for (int i = 0; i < num2.length(); i++) {
            if (num2.charAt(i) == '+') {
                index2 = i;
                break;
            }
        }
        //(a1+a2i)(b1+b2i) = a1b1-a2b2+(a1b2+a2b1)i
        int a1 = Integer.parseInt(num1.substring(0, index1));
        int a2 = Integer.parseInt(num1.substring(index1 + 1, num1.length() - 1));
        int b1 = Integer.parseInt(num2.substring(0, index2));
        int b2 = Integer.parseInt(num2.substring(index2 + 1, num2.length() - 1));

        int c1 = a1 * b1 - a2 * b2;
        int c2 = a1 * b2 + a2 * b1;
        return c1 + "+" + c2 + "i";
    }
}
