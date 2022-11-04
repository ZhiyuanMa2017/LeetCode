import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordDistance {
    Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String s = wordsDict[i];
            if (map.containsKey(s)) {
                map.get(s).add(i);
            } else {
                map.put(s, new ArrayList<>());
                map.get(s).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> one = map.get(word1);
        List<Integer> two = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < one.size() && j < two.size()) {
            res = Math.min(res, Math.abs(one.get(i) - two.get(j)));
            if (one.get(i) < two.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
