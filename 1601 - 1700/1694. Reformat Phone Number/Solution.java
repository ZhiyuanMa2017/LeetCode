class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                sb.append(number.charAt(i));
            }
        }
        int n = sb.length();
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < n) {
            if (n - index > 4) {
                res.append(sb.subSequence(index, index + 3)).append("-");
                index += 3;
            } else if (n - index == 4) {
                res.append(sb.subSequence(index, index + 2)).append("-");
                res.append(sb.subSequence(index + 2, index + 4));
                index += 4;
            } else {
                res.append(sb.subSequence(index, n));
                index = n;
            }
        }
        return res.toString();
    }
}
