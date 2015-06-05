public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }
        int la = a.length();
        int lb = b.length();
        int i = la - 1;
        int j = lb - 1;
        int k = 0;
        char[] result = new char[Math.max(la, lb) + 1];
        int p = result.length - 1;
        while (i >= -1 || j >= -1) {
            int ia = i >= 0 ? a.charAt(i) - '0' : 0;
            int ib = j >= 0 ? b.charAt(j) - '0' : 0;
            result[p--] = (char)(((ia + ib + k) % 2) + '0');
            k = (ia + ib + k) / 2;
            i--;
            j--;
        }
        return result[0] == '0' ? new String(result, 1, result.length - 1) : new String(result);
    }
}