class Solution {
    public int countLatticePoints(int[][] circles) {
        int count = 0;
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (check(circles, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean check(int[][] circles, int i, int j) {
        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            if ((i - x) * (i - x) + (j - y) * (j - y) <= r * r) {
                return true;
            }
        }
        return false;
    }
}
