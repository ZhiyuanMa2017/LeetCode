import java.util.Scanner;

class Solution {
    public static String solve(Scanner scanner) {
        String I = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < I.length(); i++) {
            sum += Integer.parseInt(String.valueOf(I.charAt(i)));
        }
        int add = 9 - sum % 9;
        add %= 9;
        String s = "";
        if (add == 0) {
            s = I.substring(0, 1) + add + I.substring(1);
        } else {
            int index = 0;
            while (index < I.length() && I.charAt(index) - '0' <= add) {
                index++;
            }
            s = I.substring(0, index) + add + I.substring(index);
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseNum = Integer.parseInt(input.nextLine());
        for (int ks = 1; ks <= caseNum; ks++) {
            String res = solve(input);
            System.out.printf("Case #%d: %s%n", ks, res);
        }
    }
}
