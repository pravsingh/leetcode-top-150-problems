
/**
 * 36. Valid Sudoku
 *
 * Determine if a 9 x 9 Sudoku board is valid.
 *
 * Example 1:
 * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],...]
 * Output: true

 *
 * SOLUTION APPROACH:
 * - Use appropriate array manipulation technique
 * - Consider sorting, two pointers, or sliding window
 * - Handle edge cases and boundary conditions
 * - Optimize for time and space complexity
 *
 * TIME COMPLEXITY: Varies based on approach - typically O(n) to O(n²)
 * SPACE COMPLEXITY: Varies based on approach - typically O(1) to O(n)
 *
 * ALTERNATIVE APPROACHES:
 * 1. Brute Force: O(n²) or higher - Check all combinations
 * 2. Sorting: O(n log n) - Sort first, then process
 * 3. Hash-based: O(n) - Use HashMap/HashSet for lookups
 *
 * KEY INSIGHTS:
 * - Choose the right data structure for the problem
 * - Consider trade-offs between time and space complexity
 * - Look for patterns that can be optimized
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidBox(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValidRow(char[][] board, int row) {
        boolean[] seen = new boolean[9];
        for (int col = 0; col < 9; col++) {
            char c = board[row][col];
            if (c != '.') {
                if (seen[c - '1']) return false;
                seen[c - '1'] = true;
            }
        }
        return true;
    }
    
    private boolean isValidColumn(char[][] board, int col) {
        boolean[] seen = new boolean[9];
        for (int row = 0; row < 9; row++) {
            char c = board[row][col];
            if (c != '.') {
                if (seen[c - '1']) return false;
                seen[c - '1'] = true;
            }
        }
        return true;
    }
    
    private boolean isValidBox(char[][] board, int startRow, int startCol) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[startRow + i][startCol + j];
                if (c != '.') {
                    if (seen[c - '1']) return false;
                    seen[c - '1'] = true;
                }
            }
        }
        return true;
    }
} 