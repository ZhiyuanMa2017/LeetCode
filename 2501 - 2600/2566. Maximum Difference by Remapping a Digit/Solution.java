class Solution {
    public int minMaxDifference(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        char first = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == first) {
                chars[i] = '0';
            }
        }
        int min = Integer.parseInt(new String(chars));
        chars = Integer.toString(num).toCharArray();
        char nonNine = '9';
        for (int i = 0; i < chars.length; i++) {
            if (nonNine == '9' && chars[i] != 9) {
                nonNine = chars[i];
            }
            if (nonNine != '9' && chars[i] == nonNine) {
                chars[i] = '9';
            }
        }
        int max = Integer.parseInt(new String(chars));
        return max - min;
    }
}
