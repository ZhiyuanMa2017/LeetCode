import java.util.Arrays;

class Solution2 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0;
        int r = 1000000009;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(houses, heaters, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] houses, int[] heaters, int x) {
        int n = houses.length;
        int m = heaters.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < m && houses[i] > heaters[j] + x) {
                j++;
            }
            if (j < m && heaters[j] - x <= houses[i] && heaters[j] + x >= houses[i]) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}
