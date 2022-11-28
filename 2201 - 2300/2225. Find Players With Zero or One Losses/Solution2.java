import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] lose = new int[100001];
        boolean[] player = new boolean[100001];
        for (int[] match : matches) {
            lose[match[1]]++;
            player[match[0]] = true;
            player[match[1]] = true;
        }
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        for (int i = 0; i < 10001; i++) {
            if (player[i]) {
                if (lose[i] == 0) {
                    zero.add(i);
                } else if (lose[i] == 1) {
                    one.add(i);
                }
            }
        }
        return List.of(zero, one);
    }
}
