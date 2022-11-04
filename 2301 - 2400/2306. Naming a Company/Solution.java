import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public long distinctNames(String[] ideas) {
        List<Set<String>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new HashSet<>());
        }
        for (String idea : ideas) {
            char first = idea.charAt(0);
            list.get(first - 'a').add(idea.substring(1));
        }

        long res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                Set<String> set1 = list.get(i);
                Set<String> set2 = list.get(j);
                int one = 0;
                for (String s : set1) {
                    if (!set2.contains(s)) {
                        one++;
                    }
                }
                int two = 0;
                for (String s : set2) {
                    if (!set1.contains(s)) {
                        two++;
                    }
                }
                res += (long) one * two * 2;
            }
        }
        return res;
    }
}
