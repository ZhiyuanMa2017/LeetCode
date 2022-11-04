class Solution {
    // sx sy
    // tx ty
    // case 1: (tx, ty) = (tx + k * ty, ty)
    // case 2: (tx, ty) = (tx, ty + k * tx)
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }

        }
        return sx == tx && sy <= ty && (ty - sy) % sx == 0 || sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
}
