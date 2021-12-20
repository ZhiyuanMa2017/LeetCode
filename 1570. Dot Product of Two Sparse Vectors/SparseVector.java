import java.util.ArrayList;
import java.util.List;

class SparseVector {
    List<int[]> vector;

    SparseVector(int[] nums) {
        vector = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                vector.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        List<int[]> vector2 = vec.vector;
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < vector.size() && j < vector2.size()) {
            if (vector.get(i)[0] == vector2.get(j)[0]) {
                res += vector.get(i)[1] * vector2.get(j)[1];
                i++;
                j++;
            } else if (vector.get(i)[0] > vector2.get(j)[0]) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SparseVector v1 = new SparseVector(new int[]{0, 0, 3, 0, 0, 0, 1, 0, 0, 3, 0, 0, 0, 5});
        SparseVector v2 = new SparseVector(new int[]{0, 5, 0, 2, 5, 4, 0, 0, 0, 0, 3, 0, 0, 0});
        System.out.println(v1.dotProduct(v2));
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
