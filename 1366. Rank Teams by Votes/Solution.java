import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] count = new int[26][n];
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char cur = vote.charAt(i);
                count[cur - 'A'][i]++;
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < votes[0].length(); i++) {
            list.add(votes[0].charAt(i));
        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character first, Character second) {
                for (int i = 0; i < n; i++) {
                    if (count[first - 'A'][i] != count[second - 'A'][i]) {
                        return count[second - 'A'][i] - count[first - 'A'][i];
                    }
                }
                return first - second;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();
    }
}
