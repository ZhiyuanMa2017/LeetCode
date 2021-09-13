class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] alphabet = new int[26];
        for (char c : text.toCharArray()) {
            alphabet[c - 'a']++;
        }
        int res = alphabet[0];
        res = Math.min(res, alphabet[1]);
        res = Math.min(res, alphabet[11] / 2);
        res = Math.min(res, alphabet[13]);
        res = Math.min(res, alphabet[14] / 2);
        return res;
    }
}
