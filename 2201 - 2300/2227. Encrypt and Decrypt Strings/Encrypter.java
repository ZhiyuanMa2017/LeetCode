import java.util.HashMap;
import java.util.Map;

class Encrypter {

    String[] map;
    Map<String, Integer> counter;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        map = new String[26];
        counter = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            char c = keys[i];
            String s = values[i];
            map[c - 'a'] = s;
        }
        for (String s : dictionary) {
            String e = encrypt(s);
            counter.put(e, counter.getOrDefault(e, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            sb.append(map[word1.charAt(i) - 'a']);
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        return counter.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
