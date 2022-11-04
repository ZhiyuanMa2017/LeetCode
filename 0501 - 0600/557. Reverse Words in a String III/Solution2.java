class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s1 : arr) {
            sb.append(new StringBuilder(s1).reverse()).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
