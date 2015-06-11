public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] A = new int[l1 + l2];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                A[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
            }
        }
        for (int i = l1 + l2 - 1; i > 0; i--) {
            A[i - 1] += A[i] / 10;
            A[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l1 + l2; i++) {
            if (A[i] > 0 || sb.length() > 0 || sb.length() == 0 && i == l1 + l2 - 1) {
                sb.append(A[i]);
            }
        }
        return sb.toString();
    }
}