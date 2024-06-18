import java.util.Arrays;

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int left = 0;
        int right = warehouse.length - 1;
        int index = boxes.length - 1;
        int res = 0;
        while (left <= right && index >= 0) {
            if (warehouse[left] >= boxes[index]) {
                res++;
                left++;
            } else if (warehouse[right] >= boxes[index]) {
                res++;
                right--;
            }
            index--;
        }
        return res;
    }
}
