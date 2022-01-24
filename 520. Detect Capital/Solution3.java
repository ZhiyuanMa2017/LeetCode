class Solution3 {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }
        return count == 0 || count == word.length() || count == 1 && Character.isUpperCase(word.charAt(0));
    }
}
