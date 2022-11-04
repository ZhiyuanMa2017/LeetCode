class Solution {
    public boolean canPermutePalindrome(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count ^= (1 << (c - 'a'));
        }
        return (count & (count - 1)) == 0;
    }
}
