public class Anagrams {
    public java.util.List<String> anagrams(String[] strs) {
        java.util.List<String> result = new java.util.ArrayList<String>();
        if (strs != null && strs.length > 1) {
            java.util.Map<String, Integer> map = new java.util.HashMap<String, Integer>();
            for (int i = 0; i < strs.length; i++) {
                String s = strs[i];
                int[] counts = new int[26];
                int j;
                for (j = 0; j < s.length(); j++) {
                    counts[s.charAt(j) - 'a']++;
                }
                for (j = 1; j < counts.length; j++) {
                    counts[j] += counts[j - 1];
                }
                char[] ns = new char[s.length()];
                for (j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    ns[--counts[c - 'a']] = c;
                }
                String n = new String(ns);
                if (map.containsKey(n)) {
                    if (map.get(n) > -1) {
                        result.add(strs[map.get(n)]);
                    }
                    result.add(strs[i]);
                    map.put(n, -1);
                }
                else {
                    map.put(n, i);
                }
            }
        }
        return result;
    }
}