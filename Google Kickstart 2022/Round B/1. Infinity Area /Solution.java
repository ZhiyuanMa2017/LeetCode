import java.util.Scanner;

class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void solve(int t) {
        String P = scanner.nextLine();
        String[] path = P.split(" ");
        int R = Integer.parseInt(path[0]);
        int A = Integer.parseInt(path[1]);
        int B = Integer.parseInt(path[2]);
        long res = (long) R * R;
        boolean a = true;
        while (R != 0) {
            if (a) {
                R = R * A;
                res += (long) R * R;
                a = false;
            } else {
                R = R / B;
                res += (long) R * R;
                a = true;
            }
        }
        double r = res * Math.PI;
        print(t, String.format("%.6f", r));
    }

    private static void print(int t, String res) {
        System.out.println("Case #" + t + ": " + res);
    }

    public static void main(String[] args) {
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }
}
