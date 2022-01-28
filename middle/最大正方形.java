class Solution {//动态规划，子状态是什么实在是太重要了，这决定了状态转移方程可不可以列出
  //一开始卡住就是子状态想错了 设ans[i][j]以i j为边界的区域的最大正方形，而正确解法是i j为角的最大正方形，
  //有时候动态规划没办法直接得到题目要求的结果（比如该题），需要多一些处理，不要以直接得到题目结果为目的设置子状态
    public int maximalSquare(char[][] matrix) {
        int maxside=0;
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return maxside;
        }
        int m=matrix.length,n=matrix[0].length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    if(i==0||j==0){
                        ans[i][j]=1;
                    }else{
                        ans[i][j]=Math.min(ans[i-1][j-1],Math.min(ans[i-1][j],ans[i][j-1]))+1;
                    }
                }
                maxside=Math.max(maxside,ans[i][j]);
            }
        }
        return maxside*maxside;
    }
}
