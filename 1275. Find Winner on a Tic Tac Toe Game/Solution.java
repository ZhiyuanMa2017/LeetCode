class Solution {
    public String tictactoe(int[][] moves) {
        int[] colA = new int[3];
        int[] rowA = new int[3];
        int[] colB = new int[3];
        int[] rowB = new int[3];
        int diaA = 0;
        int diaAA = 0;
        int diaB = 0;
        int diaBB = 0;
        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            if (i % 2 == 0) {
                rowA[r]++;
                colA[c]++;
                if (r == c) {
                    diaA++;
                }
                if (r + c == 2) {
                    diaAA++;
                }
            } else {
                rowB[r]++;
                colB[c]++;
                if (r == c) {
                    diaB++;
                }
                if (r + c == 2) {
                    diaBB++;
                }
            }
            if (diaA == 3 || diaAA == 3 || rowA[r] == 3 || colA[c] == 3) {
                return "A";
            }
            if (diaB == 3 || diaBB == 3 || rowB[r] == 3 || colB[c] == 3) {
                return "B";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
