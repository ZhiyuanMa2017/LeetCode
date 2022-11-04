import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RangeFreqQuery {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                map.put(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) {
            return 0;
        }
        List<Integer> list = map.get(value);
        if (right < list.get(0)) {
            return 0;
        }
        if (left > list.get(list.size() - 1)) {
            return 0;
        }
        // smallest number larger than or equal to left
        int l = 0;
        int h = list.size() - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            int num = list.get(mid);
            if (num >= left) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        int index1 = l;

        //largest number smaller than or equal to right
        l = 0;
        h = list.size() - 1;
        while (l < h) {
            int mid = l + (h - l + 1) / 2;
            int num = list.get(mid);
            if (num > right) {
                h = mid - 1;
            } else {
                l = mid;
            }
        }
        int index2 = l;
        return index2 - index1 + 1;
    }

    public static void main(String[] args) {
        RangeFreqQuery r = new RangeFreqQuery(new int[]{1, 1, 1, 2, 2});
        System.out.println(r.query(0, 1, 2));
        System.out.println(r.query(0, 2, 1));
        System.out.println(r.query(3, 3, 2));
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
