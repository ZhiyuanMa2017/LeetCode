import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> returnlist = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            while(i + 1 < nums.length && (nums[i + 1]-nums[i]) == 1) {
                i++;
            }
            if (a == nums[i]) {
                returnlist.add(String.valueOf(a));
            }
            if (a != nums[i]) {
                returnlist.add(a +"->"+ nums[i]);
            }
        }
        return returnlist;
    }
}
