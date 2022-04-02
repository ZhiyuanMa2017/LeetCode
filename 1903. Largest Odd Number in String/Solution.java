class Solution {
    public String largestOddNumber(String num) {
        int j = num.length() - 1;
        while (j >= 0) {
            if ((int) num.charAt(j) % 2 == 0) {
                j--;
            } else {
                break;
            }
        }
        if (j >= 0) {
            return num.substring(0, j + 1);
        } else {
            return "";
        }
    }
}
