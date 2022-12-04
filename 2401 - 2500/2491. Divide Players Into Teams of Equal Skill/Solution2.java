import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        long res = 0;
        for (int i = 0; i < n / 2; i++) {
            if (skill[i] + skill[n - i - 1] != skill[0] + skill[n - 1]) {
                return -1;
            }
            res += (long) skill[i] * skill[n - i - 1];
        }
        return res;
    }
}
