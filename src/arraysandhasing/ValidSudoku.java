package arraysandhasing;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {
        System.out.println(isValidSudokuIndexedArray(new char[][] {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','2','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','.','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}}
        ));
    }

    public static boolean isValidSudokuNonIndex(char[][] board) {
        HashMap<Integer, HashSet<Character>> columnMap = new HashMap<>();

        int colSize = board[0].length;
        int rowCount = 0;
        for (char[] row : board) {
            HashSet<Character> c = new HashSet<>();
            
            for (char col : row) {
                HashSet<Character> colSet = new HashSet<>();
                if (rowCount==0){
                    columnMap.put(rowCount, new HashSet<>());
                }

                if(col == '.')
                    continue;

                if(columnMap.containsKey(rowCount))
                    colSet = columnMap.get(rowCount);
                else
                    columnMap.put(rowCount, colSet);

                    colSet.add(col);
                    columnMap.put(rowCount, colSet);
                
                if (c.contains(col))
                    return false;

                c.add(col);
            }
            rowCount++;
        }

        return true;
    }

    public static boolean isValidSudokuIndexedArray(char[][] board) {
        HashMap<Integer, HashSet<Character>> columnHashMap = new HashMap<>();
        for(int i=0; i < board.length; i++){
            HashSet<Character> rowSet = new HashSet<>();
            for(int j=0; j < board.length; j++){
                columnHashMap.put(j, new HashSet<>());
                if(board[i][j] == '.')
                    continue;

                if(rowSet.contains(board[i][j]) || columnHashMap.get(j).contains(board[i][j]))
                    return false;

                rowSet.add(board[i][j]);
                columnHashMap.get(j).add(board[i][j]);
            }
        }

        return true;
    }

}
