class Solution {
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String w = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                w = threeDigitNum(num % 1000) + THOUSANDS[i] + " " + w;
            }
            i++;
            num /= 1000;
        }
        return w.trim();
    }

    private String threeDigitNum(int n) {
        if (n == 0) {
            return "";
        } else if (n < 20) {
            return LESS_THAN_20[n] + " ";
        } else if (n < 100) {
            return TENS[n / 10] + " " + threeDigitNum(n % 10);
        } else {
            return LESS_THAN_20[n / 100] + " Hundred " + threeDigitNum(n % 100);
        }
    }
}
