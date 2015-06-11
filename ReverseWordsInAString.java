public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int l = s.length();
        int i = l - 1;
        int j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
            while (j >= 0 && s.charAt(j) != ' ') j--;
            if (j >= i) {
                break;
            }
            sb.append(sb.length() > 0 ? " " : "");
            sb.append(s.substring(j + 1, i + 1));
            i = j;
        }
        return sb.toString();
    }
}