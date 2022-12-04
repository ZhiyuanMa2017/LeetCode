class Solution {
    public long dividePlayers(int[] skill) {
        int[] count = new int[1005];
        int sum = 0;
        int n = skill.length;
        for (int i : skill) {
            sum += i;
            count[i]++;
        }
        long res = 0;
        int s = sum / (n / 2);
        if (s * (n / 2) != sum) {
            return -1;
        }
        for (int i = 1; i <= s / 2; i++) {
            while (count[i] > 0) {
                int next = s - i;
                if (count[next] == 0) {
                    return -1;
                }
                res += i * next;
                count[i]--;
                count[next]--;
            }
        }
        return res;
    }
}
