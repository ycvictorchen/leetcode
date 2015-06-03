public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int fi = 0;
        int ei = 0;
        int l = s.length();
        for (int i = 0; i < l; i++) {
            int j = 0;
            while (i - j >= 0 && i + j < l && s.charAt(i - j) == s.charAt(i + j)) j++;
            if (2 * j - 2 > ei - fi) {
                fi = i - j + 1;
                ei = i + j - 1;
            }
            j = 0;
            while (i - j - 1 >= 0 && i + j < l && s.charAt(i - j - 1) == s.charAt(i + j)) j++;
            if (2 * j - 1 > ei - fi) {
                fi = i - j;
                ei = i + j - 1;
            }
        }
        return s.substring(fi, ei + 1);
    }
}