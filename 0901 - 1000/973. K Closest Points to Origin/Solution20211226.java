import java.util.Arrays;
import java.util.Random;

class Solution20211226 {
    Random rand;

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        rand = new Random();
        quickSelect(points, 0, n - 1, k);
        return Arrays.copyOf(points, k);
    }

    private void quickSelect(int[][] points, int l, int r, int k) {
        int pivotIndex = l + rand.nextInt(r - l + 1);
        int pivotVal = points[pivotIndex][0] * points[pivotIndex][0]
                + points[pivotIndex][1] * points[pivotIndex][1];
        swap(points, r, pivotIndex);
        int index = l;
        for (int i = l; i < r; i++) {
            int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dis <= pivotVal) {
                swap(points, index, i);
                index++;
            }
        }
        swap(points, r, index);
        if (index - l + 1 > k) {
            quickSelect(points, l, index - 1, k);
        } else if (index - l + 1 < k) {
            quickSelect(points, index + 1, r, k - (index - l + 1));
        }

    }

    private void swap(int[][] points, int l, int r) {
        int[] tmp = points[l];
        points[l] = points[r];
        points[r] = tmp;
    }
}
