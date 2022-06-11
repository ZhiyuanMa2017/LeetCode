class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int total = 4 * 24;
        int login = timeToMinute(loginTime);
        int logout = timeToMinute(logoutTime);
        int begin = (login + 14) / 15;
        int end = logout / 15;
        if (login < logout) {
            return Math.max(0, end - begin);
        } else {
            return total - begin + end;
        }
    }

    private int timeToMinute(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
        return hour * 60 + minute;
    }
}
