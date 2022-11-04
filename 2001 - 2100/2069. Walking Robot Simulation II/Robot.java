class Robot {
    int w;
    int h;
    int x;
    int y;
    int[] dirs;
    int d;

    public Robot(int width, int height) {
        w = width;
        h = height;
        x = 0;
        y = 0;
        dirs = new int[]{0, 1, 0, -1, 0};
        d = 1;
    }

    public void step(int num) {
        int cur = 0;
        if (num > (2 * w + 2 * h - 4)) {
            num %= (2 * w + 2 * h - 4);
            if (x == 0 && y == 0) {
                d = 2;
            }
        }
        while (cur < num) {
            while (x + dirs[d] < 0 || x + dirs[d] >= w || y + dirs[d + 1] < 0 || y + dirs[d + 1] >= h) {
                d = (d - 1 + 4) % 4;
            }
            x += dirs[d];
            y += dirs[d + 1];
            cur++;
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (d == 1) {
            return "East";
        } else if (d == 2) {
            return "South";
        } else if (d == 3) {
            return "West";
        } else {
            return "North";
        }
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
