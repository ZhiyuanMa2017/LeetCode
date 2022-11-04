class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int cur = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (cur >= plants[i]) {
                cur -= plants[i];
                res++;
            } else {
                res += i + i + 1;
                cur = capacity;
                cur -= plants[i];
            }
        }
        return res;
    }
}
