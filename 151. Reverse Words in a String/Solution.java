class Solution {
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder(parts[parts.length - 1]);
        for (int i = parts.length - 2; i >= 0; i--) {
            stringBuilder.append(" ");
            stringBuilder.append(parts[i]);
        }
        return stringBuilder.toString();
    }
}
