import java.util.Arrays;
import java.util.Random;

class Solution2 {
    Random random;

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        random = new Random();
        quickSelect(points, 0, n - 1, k);
        return Arrays.copyOf(points, k);
    }

    private void quickSelect(int[][] points, int left, int right, int k) {
        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivotDis = points[pivotIndex][0] * points[pivotIndex][0]
                + points[pivotIndex][1] * points[pivotIndex][1];
        swap(points, right, pivotIndex);
        int index = left - 1;
        for (int i = left; i < right; i++) {
            int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dis <= pivotDis) {
                index++;
                swap(points, index, i);
            }
        }
        index++;
        swap(points, index, right);
        // [left, toSwapIndex-1] [toSwapIndex+1,right]
        if (k < index - left + 1) {
            quickSelect(points, left, index - 1, k);
        } else if (k > index - left + 1) {
            quickSelect(points, index + 1, right, k - (index - left + 1));
        }
    }

    private void swap(int[][] points, int index1, int index2) {
        int[] tmp = points[index1];
        points[index1] = points[index2];
        points[index2] = tmp;
    }
}
