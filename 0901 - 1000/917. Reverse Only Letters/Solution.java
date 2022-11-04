class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (!Character.isLetter(chars[i]) && i < j) {
                i++;
            }
            while (!Character.isLetter(chars[j]) && i < j) {
                j--;
            }
            Character tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}
