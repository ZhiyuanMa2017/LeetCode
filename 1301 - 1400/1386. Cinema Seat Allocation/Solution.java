import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int col = reservedSeat[1];
            map.put(row, map.getOrDefault(row, 0) | (1 << (col - 1)));
        }
        int a = 0b0111111110;
        int b = 0b0000011110;
        int c = 0b0111100000;
        int d = 0b0001111000;
        int res = 0;
        for (Integer row : map.keySet()) {
            int curMask = map.get(row);
            System.out.println(Integer.toBinaryString(curMask));
            if ((curMask & a) == a) {
                System.out.println(Integer.toBinaryString(curMask & a));
                res += 2;
            } else if ((curMask & b) == b) {
                res++;
            } else if ((curMask & c) == c) {
                res++;
            } else if ((curMask & d) == d) {
                res++;
            }
        }
        return res + (n - map.size()) * 2;
    }
}
