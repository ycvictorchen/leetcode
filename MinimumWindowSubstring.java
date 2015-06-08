public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if (S == null || T == null || S.length() < T.length() || T.length() == 0) {
            return "";
        }
        java.util.Map<Character, Integer> map = new java.util.HashMap<Character, Integer>();
        String result = "";
        int ls = S.length();
        int lt = T.length();
        for (int i = 0; i < lt; i++) {
            char c = T.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        int j = -1;
        int t = lt;
        for (int i = 0; i < ls; i++) {
            char c = S.charAt(i);
            if (map.containsKey(c)) {
                if (j == -1) {
                    j = i;
                }
                if (map.get(c) > 0) {
                    if (--t == 0) {
                        result = S.substring(j, i + 1);
                    }
                }
                map.put(c, map.get(c) - 1);
                if (c == S.charAt(j)) {
                    while (j < i) {
                        if (map.containsKey(S.charAt(j))) {
                            if (map.get(S.charAt(j)) >= 0) {
                                break;
                            }
                            map.put(S.charAt(j), map.get(S.charAt(j)) + 1);
                        }
                        j++;
                    }
                    if (t == 0 && i - j + 1 < result.length()) {
                        result = S.substring(j, i + 1);
                    }
                }
            }
        }
        return result;
    }
}