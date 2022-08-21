class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        int n = energy.length;
        for (int i = 0; i < n; i++) {
            if (initialEnergy <= energy[i]) {
                int need = energy[i] - initialEnergy + 1;
                res += need;
                initialEnergy += need;
            }
            if (initialExperience <= experience[i]) {
                int need = experience[i] - initialExperience + 1;
                res += need;
                initialExperience += need;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return res;
    }
}
