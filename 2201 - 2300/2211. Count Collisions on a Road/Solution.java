class Solution {
    public int countCollisions(String directions) {
        int l = 0;
        int r = directions.length() - 1;
        while (l < directions.length() && directions.charAt(l) == 'L') {
            l++;
        }
        while (r >= 0 && directions.charAt(r) == 'R') {
            r--;
        }
        int res = 0;
        for (int i = l; i <= r; i++) {
            if (directions.charAt(i) != 'S') {
                res++;
            }
        }
        return res;
    }
}
