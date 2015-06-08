public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int l = s.length();
        int i = l - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        if (i >= 0) {
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') j--;
            return i - j;
        }
        return 0;
    }
}