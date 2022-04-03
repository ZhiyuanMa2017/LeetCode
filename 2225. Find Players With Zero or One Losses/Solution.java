import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> win = new HashMap<>();
        Map<Integer, Integer> lose = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            win.put(winner, win.getOrDefault(winner, 0) + 1);
            lose.put(loser, lose.getOrDefault(loser, 0) + 1);
        }

        List<Integer> notLose = new ArrayList<>();
        for (Integer integer : win.keySet()) {
            if (!lose.containsKey(integer)) {
                notLose.add(integer);
            }
        }
        List<Integer> loseOne = new ArrayList<>();
        for (Integer integer : lose.keySet()) {
            if (lose.get(integer) == 1) {
                loseOne.add(integer);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        Collections.sort(notLose);
        Collections.sort(loseOne);
        res.add(notLose);
        res.add(loseOne);
        return res;
    }
}
