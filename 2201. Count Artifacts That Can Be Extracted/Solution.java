import java.util.HashSet;
import java.util.Set;

class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Set<Integer> set = new HashSet<>();
        int fac = 1000000;
        for (int[] ints : dig) {
            set.add(ints[0] * fac + ints[1]);
        }
        int res = 0;
        for (int[] artifact : artifacts) {
            boolean find = true;
            for (int x = artifact[0]; x <= artifact[2]; x++) {
                if (!find) {
                    break;
                }
                for (int y = artifact[1]; y <= artifact[3]; y++) {
                    if (!set.contains(x * fac + y)) {
                        find = false;
                        break;
                    }
                }

            }
            if (find) {
                res++;
            }
        }
        return res;
    }
}
