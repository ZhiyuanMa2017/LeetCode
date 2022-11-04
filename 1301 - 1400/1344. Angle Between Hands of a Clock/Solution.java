class Solution {
    public double angleClock(int hour, int minutes) {
        double h = hour % 12 + (double) minutes / 60;
        double hDegree = 360.0 / 12 * h;
        double mDegree = 360.0 / 60 * minutes;
        double degree = Math.abs(hDegree - mDegree);
        if (degree >= 180) {
            degree = 360 - degree;
        }
        return degree;
    }
}
