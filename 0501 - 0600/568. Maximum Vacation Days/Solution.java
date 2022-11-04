class Solution {
    int[][] memo;
    int[][] flights;
    int[][] days;

    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        memo = new int[n][k];
        this.flights = flights;
        this.days = days;
        return dfs(0, 0);
    }

    private int dfs(int curCity, int curWeek) {
        if (curWeek == days[0].length) {
            return 0;
        }
        if (memo[curCity][curWeek] > 0) {
            return memo[curCity][curWeek];
        }
        int res = 0;
        for (int next = 0; next < flights.length; next++) {
            if (next == curCity || flights[curCity][next] == 1) {
                res = Math.max(res, dfs(next, curWeek + 1) + days[next][curWeek]);
            }
        }
        memo[curCity][curWeek] = res;
        return res;
    }
}
