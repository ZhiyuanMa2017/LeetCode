class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int left = 0;
        int right = 0;
        while (left < s.length) {
            while (right < s.length && s[right] != ' ') {
                right++;
            }
            reverse(s, left, right - 1);
            left = right + 1;
            right++;
        }
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
