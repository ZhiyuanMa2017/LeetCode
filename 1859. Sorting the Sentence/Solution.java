class Solution {
    public String sortSentence(String s) {
        String[] path = s.split(" ");
        String[] res = new String[path.length];
        for (String s1 : path) {
            int index = s1.charAt(s1.length() - 1) - '0';
            res[index - 1] = s1.substring(0, s1.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String r : res) {
            sb.append(r).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
