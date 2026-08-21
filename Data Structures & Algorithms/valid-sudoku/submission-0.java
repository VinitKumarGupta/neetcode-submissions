class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Validate rows and columns
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowChars = new HashSet<>();
            HashSet<Character> columnChars = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // for rows
                if (board[i][j] != '.') {
                    if (rowChars.contains(board[i][j])) return false;
                    else rowChars.add(board[i][j]);
                }

                // for columns
                if (board[j][i] != '.') {
                    if (columnChars.contains(board[j][i])) return false;
                    else columnChars.add(board[j][i]);
                }
            }
        }

        // Validate boxes (0-9)
        for (int box = 0; box < 9; box++) {
            HashSet<Character> boxChars = new HashSet<>();

            int rowStart = (box / 3) * 3;
            int colStart = (box % 3) * 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i + rowStart][j + colStart] != '.') {
                        if (boxChars.contains(board[i + rowStart][j + colStart])) return false;
                        else boxChars.add(board[i + rowStart][j + colStart]);
                    }
                }
            }
        }

        return true;
    }
}
