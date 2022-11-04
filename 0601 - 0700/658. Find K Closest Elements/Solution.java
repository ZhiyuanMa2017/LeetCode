import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int startLow = 0;
        int startHigh = arr.length - k;
        while (startLow < startHigh) {
            int start = startLow + (startHigh - startLow) / 2;
            int end = start + k;
            if (x - arr[start] > arr[end] - x) {
                startLow = start + 1;
            } else {
                startHigh = start;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = startLow; i < startLow + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
