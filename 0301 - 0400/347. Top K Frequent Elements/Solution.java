import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    Map<Integer, Integer> map;
    Random random;

    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        random = new Random();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] freq = new int[map.keySet().size()];
        int i = 0;
        for (Integer number : map.keySet()) {
            freq[i] = number;
            i++;
        }
        quickSelect(freq, 0, freq.length - 1, k);
        return Arrays.copyOf(freq, k);
    }

    private void quickSelect(int[] freq, int left, int right, int k) {
        int pivotIndex = left + random.nextInt(right - left + 1);
        int pivotVal = map.get(freq[pivotIndex]);
        swap(freq, pivotIndex, right);
        int index = left - 1;
        for (int i = left; i < right; i++) {
            if (map.get(freq[i]) >= pivotVal) {
                index++;
                swap(freq, index, i);
            }
        }
        index++;
        swap(freq, index, right);
        if (k < index - left + 1) {
            quickSelect(freq, left, index - 1, k);
        } else if (k > index - left + 1) {
            quickSelect(freq, index + 1, right, k - (index - left + 1));
        }

    }

    private void swap(int[] freq, int l, int r) {
        int temp = freq[l];
        freq[l] = freq[r];
        freq[r] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}
