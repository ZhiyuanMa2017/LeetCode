class Solution {
    public int maxDistToClosest(int[] seats) {
        int left = -1;
        int maxdis = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                continue;
            } else {
                if (left == -1) {
                    maxdis = i;
                } else {
                    maxdis = Math.max(maxdis, (i - left) / 2);
                }
                left = i;
            }
        }
        if (seats[seats.length - 1] == 0) {
            maxdis = Math.max(maxdis, seats.length - 1 - left);
        }
        return maxdis;
    }
}
