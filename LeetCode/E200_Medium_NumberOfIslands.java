public class E200_Medium_NumberOfIslands {
    /**
     * [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
     * [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
     * [["1","0","1"],["0","0","0"],["1","0","1"]]
     * 
     * @param args
     */
  
    public int numIslands(char[][] grid) {
        int islands =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    islands++;
                    dfs(grid,i,j);
                }
            }
        }
        
        return islands;
        
        
        
    }
    
    public void dfs(char[][] grid, int i, int j){
        //Verify if is out of the box or if the position is water
        if(j<0 || i<0 || i==grid.length || j==grid[0].length ||  grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        
        dfs(grid,  i, j+1 ); //right
        dfs(grid,  i+1, j ); //Bottom
        
        dfs(grid,  i , j-1 ); //Left
        dfs(grid,  i-1 , j ); //top
        
    }
    
}
