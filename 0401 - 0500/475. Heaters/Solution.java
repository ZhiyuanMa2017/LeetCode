import java.util.TreeSet;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int h : heaters) {
            set.add(h);
        }
        for (int house : houses) {
            Integer ceiling = set.ceiling(house);
            Integer floor = set.floor(house);
            int dis = Integer.MAX_VALUE;
            if (ceiling != null) {
                dis = ceiling - house;
            }
            if (floor != null) {
                dis = Math.min(dis, house - floor);
            }
            res = Math.max(res, dis);
        }
        return res;
    }
}
