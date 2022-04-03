import java.util.Arrays;
import java.util.Scanner;

class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void solve(int t) {
        String I = scanner.nextLine();
        String D = scanner.nextLine();
        int[] ds = new int[Integer.parseInt(I)];
        String[] path = D.split(" ");
        for (int i = 0; i < path.length; i++) {
            ds[i] = Integer.parseInt(path[i]);
        }
        Arrays.sort(ds);
        int res = 0;
        int index = 0;
        while (index < ds.length) {
            if (res + 1 <= ds[index]) {
                res++;
            }
            index++;
        }

        print(t, String.valueOf(res));
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
