import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        int res = 0;
        int cur = 0;
        for (int i = 25; i >= 0; i--) {
            int time = cur / 8 + 1;
            res += count[i] * time;
            cur++;
        }
        return res;
    }
}
