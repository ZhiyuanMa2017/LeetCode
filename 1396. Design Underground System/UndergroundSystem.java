import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndergroundSystem {
    Map<Integer, Pair> checkIn;
    Map<String, List<Integer>> timeTable;

    class Pair {
        String station;
        int time;

        Pair(String s, int i) {
            station = s;
            time = i;
        }
    }

    public UndergroundSystem() {
        checkIn = new HashMap<>();
        timeTable = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Pair cur = new Pair(stationName, t);
        checkIn.put(id, cur);
    }

    public void checkOut(int id, String stationName, int t) {
        int startTime = checkIn.get(id).time;
        String startStation = checkIn.get(id).station;
        checkIn.remove(id);
        String beginEnd = startStation + " " + stationName;
        timeTable.putIfAbsent(beginEnd, new ArrayList<>());
        timeTable.get(beginEnd).add(t - startTime);

    }

    public double getAverageTime(String startStation, String endStation) {
        double sum = 0;
        int count = 0;
        String beginEnd = startStation + " " + endStation;
        if (!timeTable.containsKey(beginEnd)) {
            return sum;
        }
        for (Integer integer : timeTable.get(beginEnd)) {
            sum += integer;
            count++;
        }
        return sum / count;
    }

    public static void main(String[] args) {

    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
