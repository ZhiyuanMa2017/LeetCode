class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return construct(grid, 0, 0, n - 1, n - 1);
    }

    private Node construct(int[][] grid, int x1, int y1, int x2, int y2) {
        Node cur = new Node();
        if (x1 == x2 && y1 == y2) {
            cur.val = grid[x1][y1] == 1;
            cur.isLeaf = true;
            return cur;
        } else {
            int first = grid[x1][y1];
            boolean allSame = true;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (grid[i][j] != first) {
                        allSame = false;
                        break;
                    }
                }
            }
            if (allSame) {
                cur.val = grid[x1][y1] == 1;
                cur.isLeaf = true;
                return cur;
            } else {
                int len = (x2 - x1) / 2;
                cur.topLeft = construct(grid, x1, y1, x1 + len, y1 + len);
                cur.bottomLeft = construct(grid, x2 - len, y1, x2, y1 + len);
                cur.topRight = construct(grid, x1, y2 - len, x1 + len, y2);
                cur.bottomRight = construct(grid, x2 - len, y2 - len, x2, y2);
                return cur;
            }
        }
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
