import java.util.Scanner;

class Solution {
    public static int solve(Scanner scanner) {
        String I = scanner.nextLine();
        String[] parts = I.split(" ");
        int first = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[1]);
        int res = 0;
        for (int i = first; i <= second; i++) {
            if (check(i)) {
                res++;
            }
        }
        return res;
    }

    private static boolean check(int num) {
        int product = 1;
        int sum = 0;
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            int cur = Integer.parseInt(String.valueOf(s.charAt(i)));
            product *= cur;
            sum += cur;
        }
        return product % sum == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseNum = Integer.parseInt(input.nextLine());
        for (int ks = 1; ks <= caseNum; ks++) {
            int res = solve(input);
            System.out.printf("Case #%d: %d%n", ks, res);
        }
    }
}
