import java.util.Arrays;

class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int c = 0;
        int i = 0;
        for (int bus : buses) {
            c = capacity;
            while (c > 0 && i < passengers.length && passengers[i] <= bus) {
                c--;
                i++;
            }
        }
        i--;
        int res;
        if (c > 0) {
            res = buses[buses.length - 1];
        } else {
            res = passengers[i];
        }
        while (i >= 0 && passengers[i] == res) {
            i--;
            res--;
        }
        return res;
    }
}
