import java.util.HashMap;
import java.util.Map;

class SparseVector2 {
    Map<Integer, Integer> vector;

    SparseVector(int[] nums) {
        vector = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                vector.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> vector2 = vec.vector;
        int res = 0;
        for (Integer key : vector.keySet()) {
            if (vector2.containsKey(key)) {
                res += vector2.get(key) * vector.get(key);
            }
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
