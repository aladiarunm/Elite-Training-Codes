class Solution {

    class Cell{
        int row;
        int col;
    }

    Cell isFree(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    Cell c = new Cell();
                    c.row = i;
                    c.col = j;
                    return c;
                }
            }
        }
        return null;
    }

    public boolean solve(char[][] board,boolean[][] rc,boolean[][] cc,boolean[][] rmc){

        Cell cell = isFree(board);
        if(cell == null) return true;

        int row = cell.row;
        int col = cell.col;
        int rmi = (row/3)*3 + (col/3);

        for(int i=1;i<10;i++){
            if(rc[row][i] || cc[col][i] || rmc[rmi][i]) continue;
            rc[row][i] = cc[col][i] = rmc[rmi][i] = true;
            board[row][col] = (char)('0'+i);
            if(solve(board,rc,cc,rmc)) return true;
            board[row][col] = '.';
            rc[row][i] = cc[col][i] = rmc[rmi][i] = false;
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        
        boolean[][] rc = new boolean[9][10];
        boolean[][] cc = new boolean[9][10];
        boolean[][] rmc = new boolean[9][10];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] !='.'){
                    int dig = board[i][j] - '0';
                    int rmi = (i/3)*3 + (j/3);
                    rc[i][dig] = cc[j][dig] = rmc[rmi][dig] = true;
                }
            }
        }

        solve(board,rc,cc,rmc);
    }
}
