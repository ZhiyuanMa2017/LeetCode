class Solution2 {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|.[a-z]*}");
    }
}
