//lt 994 BFS approach

class Solution {
    public int orangesRotting(int[][] grid) {

        int R = grid.length;
        int C = grid[0].length;
        int oranges=0;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                    oranges++;
                }
                else if(grid[i][j] == 1){
                    oranges++;
                }
            }
        }

        if(oranges==0) return 0;

        int mins = -1;
        int[] diff = {0,-1,0,1,0};

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                oranges--;

                for(int j=0;j<4;j++){
                    int ar = curr[0] + diff[j];
                    int ac = curr[1] + diff[j+1];

                    if(ar>=0 && ar<R && ac>=0 && ac<C && grid[ar][ac] == 1){
                        q.add(new int[]{ar,ac});
                        grid[ar][ac]=2;
                        //oranges--;
                    }
                }
            } 
            mins++;  
        }
        return oranges>0 ? -1:mins;
    }
}
