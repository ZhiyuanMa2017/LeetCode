class Solution {
    public int maxProduct(String[] words) {
        int[] values = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            values[i] = 0;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                values[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((values[i] & values[j]) == 0) {
                    int tmp = words[i].length() * words[j].length();
                    res = Math.max(res, tmp);
                }
            }
        }
        return res;
    }
}
