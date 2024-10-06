class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s1.length > s2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        int i = 0;
        int j1 = s1.length - 1;
        int j2 = s2.length - 1;
        while (i < s1.length && s1[i].equals(s2[i])) {
            i++;
        }
        while (j1 >= 0 && s1[j1].equals(s2[j2])) {
            j1--;
            j2--;
        }
        return i > j1;
    }
}
