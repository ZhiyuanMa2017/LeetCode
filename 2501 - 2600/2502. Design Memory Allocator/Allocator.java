class Allocator {
    int[] nums;

    public Allocator(int n) {
        nums = new int[n];
    }

    public int allocate(int size, int mID) {
        int i = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }
            int j = i;
            while (j < nums.length && j - i < size) {
                if (nums[j] != 0) {
                    break;
                }
                j++;
            }
            if (j - i == size) {
                for (int index = i; index < j; index++) {
                    nums[index] = mID;
                }
                return i;
            } else {
                i = j + 1;
            }
        }
        return -1;
    }

    public int free(int mID) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == mID) {
                res++;
                nums[i] = 0;
            }
        }
        return res;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */
