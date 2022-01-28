class Solution {//自己写的，广度搜索，时间复杂度很垃圾
    boolean[][] check=new boolean[310][310];
    int[] line=new int[]{1,-1,0,0};
    int[] row=new int[]{0,0,1,-1};
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&check[i][j]==false){
                    count++;
                    check[i][j]=true;
                    search(grid,i,j);
                }
            }
        }
        return count;
    }
    public void search(char[][] grid,int x,int y){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<4;i++){
            int x1=x+line[i];
            int y1=y+row[i];
            if(0<=x1&&x1<m&&0<=y1&&y1<n){
                if(grid[x1][y1]=='1'&&check[x1][y1]==false){
                    check[x1][y1]=true;
                    search(grid,x1,y1);
                }
            }
        }
        return;
    }
}
