class Solution {
    public long appealSum(String S) {
        int[] alphabet = new int[26];
        long res = 0;
        long total = 0;
        for (int i = 0; i < S.length(); i++) {
            total += i + 1 - alphabet[S.charAt(i) - 'a'];
            alphabet[S.charAt(i) - 'a'] = i + 1;
            res += total;
        }
        return res;
    }
}
