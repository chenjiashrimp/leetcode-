class Solution {//递推，唯一需要注意的是边界条件和下标，一开始下标错了，从0开始计算的话终点就应该是m-1,n-1
    public int uniquePaths(int m, int n) {
        int[][] paths=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    paths[i][j]=1;
                }else{
                    paths[i][j]=paths[i-1][j]+paths[i][j-1];
                }
            }
        }
        return paths[m-1][n-1];
    }
}
