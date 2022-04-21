class MyHashSet {
    int[] arr;

    public MyHashSet() {
        arr = new int[31251];
    }

    public void add(int key) {
        int pos = key / 32;
        int index = key % 32;
        arr[pos] = arr[pos] | (1 << index);
    }

    public void remove(int key) {
        int pos = key / 32;
        int index = key % 32;
        arr[pos] = arr[pos] & ~(1 << index);
    }

    public boolean contains(int key) {
        int pos = key / 32;
        int index = key % 32;
        return (arr[pos] >> index & 1) == 1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
