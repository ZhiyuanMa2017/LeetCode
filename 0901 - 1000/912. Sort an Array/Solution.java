import java.util.Arrays;
import java.util.Random;

class Solution {
    public int[] sortArray(int[] nums) {
        return new int[]{0};
    }

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int ai = nums[i];
            while (j > 0 && nums[j - 1] > ai) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = ai;
        }
    }

    public static void mergerSort(int[] nums, int left, int right, int[] ans) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergerSort(nums, left, mid, ans);
        mergerSort(nums, mid + 1, right, ans);
        merge(nums, left, right, ans);
    }

    public static void merge(int[] nums, int left, int right, int[] ans) {
        int mid = left + (right - left) / 2;
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                ans[k] = nums[i];
                k++;
                i++;
            } else {
                ans[k] = nums[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            ans[k] = nums[i];
            k++;
            i++;
        }
        while (j <= right) {
            ans[k] = nums[j];
            k++;
            j++;
        }
        System.arraycopy(ans, 0, nums, left, right - left + 1);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);

    }

    public static int partition(int[] nums, int left, int right) {
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, pivotIndex);
        int pivot = nums[left];
        int lessThanPivot = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lessThanPivot++;
                swap(nums, i, lessThanPivot);
            }
        }
        swap(nums, left, lessThanPivot);
        return lessThanPivot;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
//        nums[i] = nums[i] ^ nums[j];
//        nums[j] = nums[i] ^ nums[j];
//        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 4, 3, 1};
//        insertionSort(nums);
//        int[] ans = new int[nums.length];
//        mergerSort(nums, 0, 4, ans);
        quickSort(nums, 0, 4);
        System.out.println(Arrays.toString(nums));
    }
}
