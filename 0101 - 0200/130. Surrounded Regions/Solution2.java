class Solution2 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        UF uf = new UF(n * m + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        uf.union(i * n + j, m * n + 1);
                    }
                } else if (board[i][j] == 'O') {
                    if (board[i - 1][j] == 'O') {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (board[i][j - 1] == 'O') {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                    if (board[i + 1][j] == 'O') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (board[i][j + 1] == 'O') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (uf.find(i * n + j) != uf.find(n * m + 1)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }


    class UF {
        int[] parent;
        int[] size;


        UF(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int p = find(i);
            int q = find(j);
            if (p == q) {
                return;
            }
            if (size[p] >= size[q]) {
                parent[q] = p;
                size[p] += size[q];
            } else {
                parent[p] = q;
                size[q] += size[p];
            }
        }
    }
}
