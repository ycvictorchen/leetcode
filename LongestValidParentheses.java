public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int result = 0;
        int l = s.length();
        int[] dp = new int[l];
        for (int i = l - 1; i >= 0; i--) {
            dp[i] = s.charAt(i) == ')' ? 0 : (
                i + 1 < l && s.charAt(i + 1) == ')' ? 2 + (i + 2 < l ? dp[i + 2] : 0) : (
                i + 1 < l && s.charAt(i + 1) == '(' && dp[i + 1] > 0 && i + 1 + dp[i + 1] < l && s.charAt(i + 1 + dp[i + 1]) == ')' ?
                2 + dp[i + 1] + (i + 2 + dp[i + 1] < l ? dp[i + 2 + dp[i + 1]] : 0) : 0
            ));
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}