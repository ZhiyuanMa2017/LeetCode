class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long res = 0;
        long end = 0;
        for (int[] customer : customers) {
            int arrival = customer[0];
            int time = customer[1];
            if (arrival >= end) {
                end = arrival + time;
            } else {
                end = end + time;
            }
            res += end - arrival;
        }
        return (double) res / n;
    }
}
