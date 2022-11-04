import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] array = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int countOne = Integer.bitCount(o1);
                int countTwo = Integer.bitCount(o2);
                if (countOne == countTwo) {
                    return o1 - o2;
                }
                return countOne - countTwo;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }
}
