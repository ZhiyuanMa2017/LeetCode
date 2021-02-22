import java.util.List;

class Solution2 {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String ds : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < ds.length() && c == ds.charAt(i)) {
                    i++;
                }
            }

            if (i == ds.length() && ds.length() >= longest.length()) {
                if (ds.length() > longest.length() || ds.compareTo(longest) < 0) {
                    longest = ds;
                }
            }
        }
        return longest;
    }
}
