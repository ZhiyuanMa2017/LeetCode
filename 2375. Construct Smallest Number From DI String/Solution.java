class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i <= pattern.length(); i++) {
            stack.append((char) (i + '1'));
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                sb.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return sb.toString();
    }
}
