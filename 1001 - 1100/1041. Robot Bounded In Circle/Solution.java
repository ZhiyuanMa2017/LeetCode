class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int direction = 0;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        // north = 0, east = 1, south = 2, west = 3
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'R') {
                direction = (direction + 1) % 4;
            } else if (instructions.charAt(i) == 'L') {
                direction = (direction + 3) % 4;
            } else {
                x += dirs[direction];
                y += dirs[direction + 1];
            }
        }
        return x == 0 && y == 0 || direction != 0;
    }
}
