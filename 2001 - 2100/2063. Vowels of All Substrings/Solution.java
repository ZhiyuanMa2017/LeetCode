class Solution {
    public long countVowels(String word) {
        int n = word.length();
        long res = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                res += (i + 1) * (n - i);
            }
        }
        return res;
    }
}
