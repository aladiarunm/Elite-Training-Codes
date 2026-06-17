//lt200  DFS approach
class Solution {

    static int[] rDiff = {-1,1,0,0};
    static int[] cDiff = {0,0,-1,1};

    static void dfs(char[][] grid,int r,int c,int R,int C){
        grid[r][c]='0';
        for(int i=0;i<4;i++){
            int row = r+rDiff[i];
            int col = c+cDiff[i];
            if(row>=0 && row<R && col>=0 && col<C){
                if(grid[row][col] == '1'){
                    dfs(grid,row,col,R,C);
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        
        int R = grid.length;
        int C = grid[0].length;
        int count = 0;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j,R,C);
                }
            }
        }
        return count;
    }
}
