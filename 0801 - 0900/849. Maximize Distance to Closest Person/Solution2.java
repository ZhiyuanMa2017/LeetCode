class Solution2 {
    public int maxDistToClosest(int[] seats) {
        int count = 0;
        int res = 0;
        boolean flag = seats[0] == 0;
        for (int seat : seats) {
            if (seat == 0) {
                count++;
            } else if (seat == 1) {
                if (flag) {
                    res = count;
                    flag = false;
                } else {
                    res = Math.max(res, (count + 1) / 2);
                }
                count = 0;
            }
        }
        res = Math.max(res, count);
        return res;
    }
}
