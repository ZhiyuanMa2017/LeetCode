import java.util.Arrays;

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int[] maxHeight = new int[warehouse.length];
        int curMin = warehouse[0];
        for (int i = 0; i < warehouse.length; i++) {
            curMin = Math.min(curMin, warehouse[i]);
            maxHeight[i] = curMin;
        }
        int i = 0;
        for (int index = warehouse.length - 1; index >= 0; index--) {
            if (i < boxes.length && maxHeight[index] > boxes[i]) {
                i++;
            }
        }
        return i;
    }
}
