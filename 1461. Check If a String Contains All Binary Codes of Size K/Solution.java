import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> stringSet = new HashSet<>();
        int need = (int) Math.pow(2, k);
        for (int i = 0; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k);
            if (!stringSet.contains(substring)) {
                stringSet.add(substring);
                need--;
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}