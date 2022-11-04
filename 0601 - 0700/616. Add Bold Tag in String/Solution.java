class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()];
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (String word : words) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (!bold[i]) {
                sb.append(s.charAt(i));
                i++;
            } else {
                int j = i;
                while (j < s.length() && bold[j]) {
                    j++;
                }
                sb.append("<b>").append(s, i, j).append("</b>");
                i = j;
            }
        }
        return sb.toString();
    }
}
