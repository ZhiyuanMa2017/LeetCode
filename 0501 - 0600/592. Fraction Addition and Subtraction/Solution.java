class Solution {
    public String fractionAddition(String expression) {
        char op = '+';
        int[] prev = new int[]{0, 1};
        int i = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == '-') {
                op = '-';
                i++;
            } else if (expression.charAt(i) == '+') {
                op = '+';
                i++;
            }
            int num = 0;
            int deno = 0;
            while (expression.charAt(i) != '/') {
                num = num * 10 + expression.charAt(i) - '0';
                i++;
            }
            i++;
            while (i < expression.length() && expression.charAt(i) != '-' && expression.charAt(i) != '+') {
                deno = deno * 10 + expression.charAt(i) - '0';
                i++;
            }
            if (op == '-') {
                num = -num;
            }
            prev = cal(prev, num, deno);
        }
        return prev[0] + "/" + prev[1];
    }

    private int[] cal(int[] prev, int num1, int deno1) {
        int num0 = prev[0];
        int deno0 = prev[1];
        if (deno0 != deno1) {
            int tmp = deno0;
            num0 *= deno1;
            deno0 *= deno1;
            num1 *= tmp;
        }
        int num = num0 + num1;
        int gcd = gcd(Math.abs(num), deno0);
        num /= gcd;
        deno0 /= gcd;
        if (num == 0) {
            deno0 = 1;
        }
        return new int[]{num, deno0};
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
