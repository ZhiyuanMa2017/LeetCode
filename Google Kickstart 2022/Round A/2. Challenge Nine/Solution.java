import java.util.Scanner;

class Solution {
    // https://codingcompetitions.withgoogle.com/kickstart/round/00000000008cb33e/00000000009e7997

    static Scanner scanner = new Scanner(System.in);

    public static void solve(int t) {
        String I = scanner.nextLine();

        int sum = 0;
        for (int i = 0; i < I.length(); i++) {
            sum += Integer.parseInt(String.valueOf(I.charAt(i)));
        }
        int add = 9 - sum % 9;
        add %= 9;
        String s;
        if (add == 0) {
            s = I.substring(0, 1) + add + I.substring(1);
        } else {
            int index = 0;
            while (index < I.length() && I.charAt(index) - '0' <= add) {
                index++;
            }
            s = I.substring(0, index) + add + I.substring(index);
        }
        print(t, s);
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
