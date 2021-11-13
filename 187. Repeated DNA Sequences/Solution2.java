import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution2 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }
        int base = 4;
        int basePower = (int) Math.pow(4, 10);
        Map<Character, Integer> map = new HashMap<>() {{
            put('A', 0);
            put('C', 1);
            put('T', 2);
            put('G', 3);
        }};
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = map.get(s.charAt(i));
        }
        int hash = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            if (i == 0) {
                for (int j = 0; j < 10; j++) {
                    hash = hash * base + nums[j];
                }
            } else {
                hash = hash * base - nums[i - 1] * basePower + nums[i + 10 - 1];
            }
            if (seen.contains(hash)) {
                set.add(s.substring(i, i + 10));
            }
            seen.add(hash);
        }
        return new ArrayList<>(set);
    }
}
