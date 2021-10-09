public class Solution {
    public static String solution(String n) {
//        int zeroMax = 0;
//        int curZero = 0;
//        for (int i = 0; i < n.length(); i++) {
//            if (n.charAt(i) == '1') {
//                curZero = 0;
//                zeroMax = Math.max(zeroMax, curZero);
//            } else {
//                curZero++;
//            }
//        }
//        zeroMax = Math.max(zeroMax, curZero);
//        if (zeroMax % 2 == 0) {
//            return "B";
//        } else {
//            return "A";
//        }
        int count = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '0') {
                count++;
            }
        }
        if (count % 2 == 0) {
            return "B";
        } else {
            return "A";
        }
    }

    public static void main(String[] args) {
        String s = "1";
        System.out.println(solution(s));
    }
}
