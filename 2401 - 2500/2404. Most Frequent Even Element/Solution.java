class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] count = new int[100001];
        for (int num : nums) {
            if (num % 2 == 0) {
                count[num]++;
            }
        }
        int res = -1;
        int freq = 0;
        for (int i = 0; i < count.length; i += 2) {
            if (count[i] > freq) {
                res = i;
                freq = count[i];
            }
        }
        return res;
    }
}
