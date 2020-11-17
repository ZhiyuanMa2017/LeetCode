import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String s1 : d) {
            if (s1.length() < result.length() || (s1.length() == result.length() && s1.compareTo(result) > 0)) {
                continue;
            }
            if (issubstring(s, s1)) {
                result = s1;
            }
        }
        return result;
    }
    public boolean issubstring(String s, String sub) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < sub.length()){
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == sub.length();
    }
}