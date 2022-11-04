import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> types = new HashSet<>(candyType.length);
        for (int i : candyType) {
            types.add(i);
        }

        return Math.min(types.size(), candyType.length / 2);
    }
}
