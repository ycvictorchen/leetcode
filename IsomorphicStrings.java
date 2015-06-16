public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s != null && t != null && s.length() == t.length()) {
            char[] A = new char[512];
            for (int i = 0, l = s.length(); i < l; i++) {
                int offsetS = s.charAt(i) - '\0';
                int offsetT = t.charAt(i) - '\0';
                if (A[offsetS] != '\0' && A[offsetS] != t.charAt(i) ||
                    A[offsetT + 256] != '\0' && A[offsetT + 256] != s.charAt(i)) {
                    return false;
                }
                A[offsetS] = t.charAt(i);
                A[offsetT + 256] = s.charAt(i);
            }
        }
        return true;
    }
}