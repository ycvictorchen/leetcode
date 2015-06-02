public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String s = strs[0];
        int i = 0;
        while (i < s.length()) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != s.charAt(i)) {
                    return s.substring(0, i);
                }
            }
            i++;
        }
        return s;
    }
}