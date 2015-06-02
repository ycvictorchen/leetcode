public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int i = 0;
        java.util.Set<Character> set = new java.util.HashSet<Character>();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (set.contains(c)) {
                while (i++ < j) {
                    char t = s.charAt(i - 1);
                    if (t == c) {
                        break;
                    }
                    set.remove(t);
                }
            }
            else {
                result = Math.max(result, j - i + 1);
                set.add(c);
            }
        }
        return result;
    }
}