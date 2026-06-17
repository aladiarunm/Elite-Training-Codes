//lc 994 BFS Approach
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int R = grid.length;
        int C = grid[0].length();

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[R][C][(1<<6)];

        int keys=0;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i].charAt(j) == '@'){
                    q.add(new int[] {i,j,0,0});
                    visited[i][j][0] = true;
                }
                else if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='f'){
                    keys++;
                }
            }
        }

        int[] diff = {0,-1,0,1,0};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0], col = cell[1], kst = cell[2], moves = cell[3];
            for(int i=0;i<4;i++){
                int ar = row + diff[i] , ac = col + diff[i+1];
                int ast = kst;
                if(ar>=0 && ar<R && ac>=0 && ac<C){
                    int ch = grid[ar].charAt(ac);
                    if(ch>='a' && ch <='f'){
                        ast = kst | (1<< (ch - 'a'));
                    }
                    else if(ch>='A' && ch<='F'){
                        if((kst & (1<< (ch - 'A')))==0) continue;
                    }
                    else if(ch == '#') continue;
                    if(visited[ar][ac][ast]) continue;

                    if(ast == ((1<<keys)-1)) return moves+1;
                    q.add(new int[]{ar,ac,ast,moves+1});
                    visited[ar][ac][ast] = true;
                }
            }
        }
        return -1;
    }
}
