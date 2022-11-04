import java.util.Arrays;

class Bitset {
    int[] nums;
    int[] reverse;
    int count;

    public Bitset(int size) {
        nums = new int[size];
        reverse = new int[size];
        Arrays.fill(reverse, 1);
        count = 0;
    }

    public void fix(int idx) {
        if (nums[idx] != 1) {
            nums[idx] = 1;
            reverse[idx] = 0;
            count++;
        }
    }

    public void unfix(int idx) {
        if (nums[idx] == 1) {
            nums[idx] = 0;
            reverse[idx] = 1;
            count--;
        }
    }

    public void flip() {
        count = nums.length - count;
        int[] temp = nums;
        nums = reverse;
        reverse = temp;
    }

    public boolean all() {
        return count == nums.length;
    }

    public boolean one() {
        return count > 0;
    }

    public int count() {
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
