import java.util.Arrays;

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] position = new int[26];
        Arrays.fill(position, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (position[c - 'a'] == -1) {
                position[c - 'a'] = i;
            } else {
                if (distance[c - 'a'] != i - position[c - 'a'] - 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
