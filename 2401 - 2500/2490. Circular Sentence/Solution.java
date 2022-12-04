class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            String next = words[(i + 1) % words.length];
            if (cur.charAt(cur.length() - 1) != next.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
