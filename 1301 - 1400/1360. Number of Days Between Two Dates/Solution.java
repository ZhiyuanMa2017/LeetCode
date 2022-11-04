class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int start = Math.min(Integer.parseInt(date1.split("-")[0]), Integer.parseInt(date2.split("-")[0]));
        return Math.abs(calculateDays(date1, start) - calculateDays(date2, start));
    }

    private int calculateDays(String date, int start) {
        String[] first = date.split("-");
        int year1 = Integer.parseInt(first[0]);
        int month1 = Integer.parseInt(first[1]);
        int day1 = Integer.parseInt(first[2]);
        return countDays(start, year1, month1, day1);
    }

    private int countDays(int startYear, int year, int month, int day) {
        int res = 0;
        for (int i = startYear; i < year; i++) {
            if (isLeapyear(i)) {
                res += 366;
            } else {
                res += 365;
            }
        }
        for (int i = 0; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                res += 31;
            } else if (i == 2) {
                res += isLeapyear(year) ? 29 : 28;
            } else {
                res += 30;
            }
        }
        res += day;
        return res;
    }

    private boolean isLeapyear(Integer year) {
        if (year % 4 != 0) {
            return false;
        } else {
            if (year % 100 != 0) {
                return true;
            } else {
                return year % 400 == 0;
            }
        }
    }
}
