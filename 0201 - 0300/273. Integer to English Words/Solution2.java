class Solution {

    private static final String[] LESS_THAN_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = new String[]{"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String res = "";
        int index = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                res = threeDigitNumToString(num % 1000) + THOUSANDS[index] + " " + res;
            }
            num /= 1000;
            index++;
        }
        return res.trim();
    }

    private String threeDigitNumToString(int num) {
        //0, 1, 11, 21, 50, 121
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + threeDigitNumToString(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + threeDigitNumToString(num % 100);
        }
    }
}
