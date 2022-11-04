class Solution {
    public static int countValidWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        int res = 0;
        for (String word : words) {
            if (isValid(word)) {
                res++;
            }
        }
        return res;
    }

    private static boolean isValid(String word) {
        boolean hyphen = false;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                return false;
            }
            if (word.charAt(i) == '-') {
                if (i == 0 || i == word.length() - 1 || hyphen) {
                    return false;
                }
                if (!Character.isLetter(word.charAt(i + 1)) || !Character.isLetter(word.charAt(i - 1))) {
                    return false;
                }
                hyphen = true;
            }
            if (word.charAt(i) == '!' || word.charAt(i) == '.' || word.charAt(i) == ',') {
                if (i != word.length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
