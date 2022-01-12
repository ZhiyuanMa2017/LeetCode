import java.util.HashSet;
import java.util.Set;

class Solution5 {
    Set<Integer> squareNums;

    protected boolean isDividedBy(int n, int count) {
        if (count == 1) {
            return squareNums.contains(n);
        }

        for (Integer square : squareNums) {
            if (isDividedBy(n - square, count - 1)) {
                return true;
            }
        }
        return false;
    }

    public int numSquares(int n) {
        squareNums = new HashSet<Integer>();
        for (int i = 1; i * i <= n; ++i) {
            this.squareNums.add(i * i);
        }

        int count = 1;
        for (; count <= n; ++count) {
            System.out.println("Round: " + count);
            if (isDividedBy(n, count)) {
                return count;
            }
        }
        return count;
    }
}
