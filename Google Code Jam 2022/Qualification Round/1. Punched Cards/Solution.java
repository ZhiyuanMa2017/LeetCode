import java.util.Scanner;

class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void solve(int t) {
        String I = scanner.nextLine();
        String[] rc = I.split(" ");
        int R = Integer.parseInt(rc[0]);
        int C = Integer.parseInt(rc[1]);
        StringBuilder plus = new StringBuilder();

        for (int i = 0; i < C; i++) {
            plus.append("+").append("-");
        }
        plus.append("+");

        StringBuilder dot = new StringBuilder();
        for (int i = 0; i < C; i++) {
            dot.append("|").append(".");
        }
        dot.append("|");

        StringBuilder res = new StringBuilder();

        StringBuilder plusOne = new StringBuilder(plus);
        plusOne.setCharAt(0, '.');
        plusOne.setCharAt(1, '.');

        StringBuilder dotOne = new StringBuilder(dot);
        dotOne.setCharAt(0, '.');

        res.append(plusOne).append("\n").append(dotOne).append("\n");

        for (int i = 1; i < R; i++) {
            res.append(plus).append("\n").append(dot).append("\n");
        }
        res.append(plus);
        print(t, res.toString());
    }

    private static void print(int t, String res) {
        System.out.println("Case #" + t + ": \n" + res);
    }

    public static void main(String[] args) {
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }
}
