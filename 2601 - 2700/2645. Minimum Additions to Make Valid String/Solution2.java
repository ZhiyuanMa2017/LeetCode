class Solution {
    public int addMinimum(String word) {
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i - 1) >= word.charAt(i)) {
                count++;
            }
        }
        return count * 3 - word.length();
    }
}
