class Solution {
    public int compareVersion(String version1, String version2) {
        String[] one = version1.split("\\.");
        String[] two = version2.split("\\.");
        int num1;
        int num2;
        for (int i = 0; i < Math.max(one.length, two.length); i++) {
            num1 = i < one.length ? Integer.parseInt(one[i]) : 0;
            num2 = i < two.length ? Integer.parseInt(two[i]) : 0;
            if (num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }

        }
        return 0;
    }
}
