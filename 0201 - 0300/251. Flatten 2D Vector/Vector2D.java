class Vector2D {

    int[][] v;
    int i;
    int j;

    public Vector2D(int[][] vec) {
        v = vec;
        i = 0;
        j = 0;
    }

    public int next() {
        if (hasNext()) {
            return v[i][j++];
        }
        return -1;
    }

    public boolean hasNext() {
        while (i < v.length && j == v[i].length) {
            j = 0;
            i++;
        }
        return i < v.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
