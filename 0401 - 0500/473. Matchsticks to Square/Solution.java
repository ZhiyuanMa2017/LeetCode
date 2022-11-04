import java.util.Arrays;

class Solution {
    int side;

    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        side = sum / 4;
        if (side * 4 != sum) {
            return false;
        }
        return backtrack(matchsticks, new int[4], matchsticks.length - 1);
    }

    private boolean backtrack(int[] matchsticks, int[] sides, int index) {
        if (index == -1) {
            return true;
        } else {
            for (int i = 0; i < 4; i++) {
                boolean seen = false;
                for (int j = 0; j < i; j++) {
                    if (sides[j] == sides[i]) {
                        seen = true;
                        break;
                    }
                }
                if (seen) {
                    continue;
                }
                sides[i] += matchsticks[index];
                if (sides[i] <= side && backtrack(matchsticks, sides, index - 1)) {
                    return true;
                }
                sides[i] -= matchsticks[index];
            }
        }
        return false;
    }
}
