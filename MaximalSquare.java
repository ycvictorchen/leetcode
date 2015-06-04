public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ml = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = matrix[i][j] == '0' ? 0 : 1 + Math.min(Math.min(
                    i > 0 ? dp[i - 1][j] : 0,
                    j > 0 ? dp[i][j - 1] : 0),
                    i > 0 && j > 0 ? dp[i - 1][j - 1] : 0
                );
                ml = Math.max(ml, dp[i][j]);
            }
        }
        return ml * ml;
    }
}