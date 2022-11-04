class Solution2 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index < spaces.length && spaces[index] == i) {
                sb.append(" ");
                index++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
