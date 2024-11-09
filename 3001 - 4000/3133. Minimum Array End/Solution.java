class Solution {
    public long minEnd(int n, int x) {
        long count = n - 1;
        long res = x;
        int indexC = 0;
        int indexR = 0;
        while ((count >> indexC) > 0) {
            if ((res >> indexR & 1) == 0) {
                res |= (count >> indexC & 1) << indexR;
                indexC++;
            }
            indexR++;
        }
        return res;
    }
}
