import java.util.Arrays;

class Solution {
    public String decodeMessage(String key, String message) {
        int[] keys = new int[26];
        int index = 0;
        Arrays.fill(keys, -1);
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c != ' ') {
                if (keys[c - 'a'] == -1) {
                    keys[c - 'a'] = index;
                    index++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                sb.append(" ");
            } else {
                sb.append((char) ('a' + keys[c - 'a']));
            }
        }
        return sb.toString();
    }
}
