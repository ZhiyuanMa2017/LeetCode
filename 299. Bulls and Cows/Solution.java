import java.util.HashMap;
import java.util.Map;

class Solution {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        Map<Character, Integer> s = new HashMap<>();
        Map<Character, Integer> g = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) {
                A++;
            } else {
                g.put(cg, g.getOrDefault(cg, 0) + 1);
                s.put(cs, s.getOrDefault(cs, 0) + 1);
            }
        }
        for (Character c : s.keySet()) {
            B += Math.min(s.get(c), g.getOrDefault(c, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A).append("A").append(B).append("B");
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getHint("1122", "2211"));
    }
}
