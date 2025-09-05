import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Traverse right (row frozen, increase col)
            for (int j = colStart; j <= colEnd; j++) {
                result.add(matrix[rowStart][j]);
            }
            rowStart++; // Shrink the top border

            // Traverse down (col frozen, increase row)
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--; // Shrink the right border

            // Traverse left (row frozen, decrease col)
            if (rowStart <= rowEnd) { // Ensure rowStart did not surpass rowEnd
                for (int j = colEnd; j >= colStart; j--) {
                    result.add(matrix[rowEnd][j]);
                }
                rowEnd--; // Shrink the bottom border
            }

            // Traverse up (col frozen, decrease row)
            if (colStart <= colEnd) { // Ensure colStart did not surpass colEnd
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
                colStart++; // Shrink the left border
            }
        }

        return result;
    }
}