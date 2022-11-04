class NumArray {
    int[] treeArray;

    private int lowBit(int x) {
        return x & -x;
    }

    private void add(int x, int val) {
        for (int i = x; i <= n; i += lowBit(i)) {
            treeArray[i] += val;
        }
    }

    private int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowBit(i)) {
            res += treeArray[i];
        }
        return res;
    }

    int n;
    int[] datas;

    public NumArray(int[] nums) {
        n = nums.length;
        datas = nums;
        treeArray = new int[n + 10];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - datas[index]);
        datas[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
