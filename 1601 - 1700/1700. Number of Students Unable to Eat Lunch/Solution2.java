class Solution2 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[]{0, 0};
        for (int i : students) {
            count[i]++;
        }
        int k;
        for (k = 0; k < sandwiches.length; k++) {
            if (count[sandwiches[k]] > 0) {
                count[sandwiches[k]]--;
            } else {
                break;
            }
        }
        return sandwiches.length - k;
    }
}
