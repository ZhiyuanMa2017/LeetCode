class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = i; j < n; j += cols + 1) {
                sb.append(encodedText.charAt(j));
            }
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
