class Solution2 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int x = startPos[0];
            int y = startPos[1];
            int cur = 0;

            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'R') {
                    y++;

                } else if (s.charAt(j) == 'L') {
                    y--;

                } else if (s.charAt(j) == 'U') {
                    x--;

                } else if (s.charAt(j) == 'D') {
                    x++;
                }
                if (x < 0 || y < 0 || x >= n || y >= n) {
                    break;
                }
                cur++;

            }
            res[i] = cur;
        }
        return res;
    }
}
