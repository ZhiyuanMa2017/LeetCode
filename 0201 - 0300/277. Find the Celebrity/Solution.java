/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        for (int i = 0; i < celebrity; i++) {
            if (knows(celebrity, i)) {
                return -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == celebrity) {
                continue;
            }
            if (!knows(i, celebrity)) {
                return -1;
            }
        }
        return celebrity;
    }
}
