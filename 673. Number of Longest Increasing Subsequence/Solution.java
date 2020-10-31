import java.util.Arrays;

class Solution {
    public static int findNumberOfLIS(int[] nums) {
        int result = 0;
        int maxlen = 0;
        int[] len = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(len, 1);
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        cnt = count[j];
                    } else if (len[j] + 1 == len[i]) {
                        cnt += count[j];
                    }
                }
            }
            count[i] = cnt;
            if(len[i] > maxlen ){
                result =cnt;
                maxlen =len[i];
            } else if(len[i] == maxlen ){
                result += cnt;
            }
        }
        return result;
    }
}
