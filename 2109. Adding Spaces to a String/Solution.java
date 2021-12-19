class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaces.length; i++) {
            if (i == 0) {
                sb.append(s, 0, spaces[i]).append(" ");
            } else {
                sb.append(s, spaces[i - 1], spaces[i]).append(" ");
            }
        }
        sb.append(s.substring(spaces[spaces.length - 1]));
        return sb.toString();
    }
}
