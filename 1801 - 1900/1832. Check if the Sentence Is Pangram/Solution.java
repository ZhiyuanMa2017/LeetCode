class Solution {
    public boolean checkIfPangram(String sentence) {
        int res = 0;
        for (char c : sentence.toCharArray()) {
            res |= 1 << (c - 'a');
        }
        return res == (1 << 26) - 1;
    }
}
