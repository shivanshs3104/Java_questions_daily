class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int i = 0, j = 0, direction = 1, idx = 0;

        while (idx < m * n) {
            result[idx++] = mat[i][j];

            if (direction == 1) {
                if (j == n - 1) {
                    i++;
                    direction = -1;
                } else if (i == 0) {
                    j++;
                    direction = -1;
                } else {
                    i--;
                    j++;
                }
            }
            else {
                if (i == m - 1) {
                    j++;
                    direction = 1;
                } else if (j == 0) {
                    i++;
                    direction = 1;
                } else {
                    i++;
                    j--;
                }
            }
        }

        return result;
    }
}