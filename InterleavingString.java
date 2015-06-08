public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                dp[i][j] = (
                    i > 0 && dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                    j > 0 && dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)
                );
            }
        }
        return dp[m][n];
    }
}