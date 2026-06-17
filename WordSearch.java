//lt79 DFS approach

class Solution {
    
    static int[][] diff = {{-1,0},{1,0},{0,1},{0,-1}};

    public static boolean dfs(char[][] board,int row,int col,int R,int C,String word,int ci){

        if(ci == word.length()) return true;

        char backup = board[row][col];
        board[row][col] = '_';

        for(int i=0;i<4;i++){
            int ar = row + diff[i][0];
            int ac = col + diff[i][1];
            if(ar>=0 && ar<R && ac>=0 && ac<C && board[ar][ac] == word.charAt(ci)){
                boolean found = dfs(board,ar,ac,R,C,word,ci+1);
                if(found) return true;
            }
        }
        board[row][col] = backup;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        
        int R = board.length;
        int C = board[0].length;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean found = dfs(board,i,j,R,C,word,1);
                    if(found) return true;
                }
            }
        }
        return false;
    }
}
