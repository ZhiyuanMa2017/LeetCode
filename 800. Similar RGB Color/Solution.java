import java.util.List;

class Solution {
    public String similarRGB(String color) {
        String first = color.substring(1, 3);
        String second = color.substring(3, 5);
        String third = color.substring(5, 7);
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(findClosestHex(first)).append(findClosestHex(second)).append(findClosestHex(third));
        return sb.toString();
    }

    private String findClosestHex(String s) {
        List<Integer> list = List.of(0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xaa, 0xbb, 0xcc, 0xdd, 0xee, 0xff);
        int num = Integer.parseInt(s, 16);
        int diff = Integer.MAX_VALUE;
        int res = -1;
        for (Integer hex : list) {
            int curDiff = Math.abs(num - hex);
            if (curDiff < diff) {
                diff = curDiff;
                res = hex;
            }
        }
        if (res == 0) {
            return "00";
        }
        return Integer.toString(res, 16);
    }
}
