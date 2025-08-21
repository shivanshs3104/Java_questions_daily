class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] heights = new int[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    heights[i][j] = 0;
                } else {
                    heights[i][j] = (i == 0 ? 0 : heights[i - 1][j]) + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minHeight = heights[i][j];
                for (int k = j; k >= 0 && minHeight > 0; k--) {
                    minHeight = Math.min(minHeight, heights[i][k]);
                    result += minHeight;
                }
            }
        }

        return result;
    }
}