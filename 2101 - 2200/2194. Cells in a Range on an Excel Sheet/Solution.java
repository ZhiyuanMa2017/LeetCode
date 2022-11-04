import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> cellsInRange(String s) {
        char a = s.charAt(0);
        int num1 = s.charAt(1) - '0';
        char b = s.charAt(3);
        int num2 = s.charAt(4) - '0';
        List<String> res = new ArrayList<>();
        for (char c = a; c <= b; c++) {
            for (int i = num1; i <= num2; i++) {
                res.add(String.valueOf(c) + String.valueOf(i));
            }
        }
        return res;
    }
}
