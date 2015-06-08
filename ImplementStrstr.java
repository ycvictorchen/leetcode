public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        int lh = haystack.length();
        int ln = needle.length();
        for (int i = 0; i <= lh - ln; i++) {
            int j = 0;
            for (; j < ln && haystack.charAt(i + j) == needle.charAt(j); j++) ;
            if (j == ln) {
                return i;
            }
        }
        return -1;
    }
}