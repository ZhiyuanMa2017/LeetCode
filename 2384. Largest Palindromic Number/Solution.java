class Solution {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (sb.length() == 0 && i == 0) {
                continue;
            }
            if (count[i] >= 2) {
                int use = count[i] / 2;
                sb.append(String.valueOf(i).repeat(use));
                count[i] -= use * 2;
            }
        }
        String middle = "";
        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                middle = String.valueOf(i);
                break;
            }
        }
        return sb.toString() + middle + sb.reverse().toString();
    }
}
