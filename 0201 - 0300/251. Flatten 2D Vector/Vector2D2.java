class Vector2D {
    int[][] vector;
    int i;
    int j;

    public Vector2D(int[][] vec) {
        vector = vec;
        i = 0;
        j = 0;
    }

    public int next() {
        move();
        int val = vector[i][j];
        j++;
        return val;
    }

    public boolean hasNext() {
        move();
        return i < vector.length;
    }

    private void move() {
        while (i < vector.length && j == vector[i].length) {
            j = 0;
            i++;
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
