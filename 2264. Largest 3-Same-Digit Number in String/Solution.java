class Solution {
    public String largestGoodInteger(String num) {
        int res = -1;
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                res = Math.max(res, num.charAt(i) - '0');
            }
        }
        if (res == -1) {
            return "";
        } else {
            return String.valueOf(res).repeat(3);
        }
    }
}
