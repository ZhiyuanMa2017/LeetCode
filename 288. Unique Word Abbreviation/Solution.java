import java.util.HashMap;
import java.util.Map;


class ValidWordAbbr {
    Map<String, String> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String key = getKey(s);
            if (map.containsKey(key) && !map.get(key).equals(s)) {
                map.put(key, "");
            } else {
                map.put(key, s);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = getKey(word);
        return !map.containsKey(key) || map.get(key).equals(word);
    }

    private String getKey(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0)).append(len - 2).append(s.charAt(len - 1));
        return sb.toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
