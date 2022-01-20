class Solution {//一样，还是递推，没啥好说的，依然注意边界条件
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] minNumbers=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(i==0&&j==0){
                   minNumbers[0][0]=grid[0][0];
                   continue;
               }
               if(i==0){
                   minNumbers[i][j]=grid[i][j]+minNumbers[i][j-1];
               }
               else if(j==0){
                   minNumbers[i][j]=grid[i][j]+minNumbers[i-1][j];
               }else{
                   minNumbers[i][j]=Math.min(minNumbers[i-1][j],minNumbers[i][j-1])+grid[i][j];
               }
            }
        }
        return minNumbers[m-1][n-1];
    }
}
