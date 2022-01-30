class Solution {//柱状图暴力法
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        if(m==0){
            return 0;
        }      
        int n=matrix[0].length;
        int[][] width=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    width[i][j]=(j==0?0:width[i][j-1])+1;
                }
            }
        }
        int ret=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    continue;
                }
                int breadth=width[i][j];
                int area=breadth;
                for(int k=i-1;k>=0;k--){
                    breadth=Math.min(breadth,width[k][j]);
                    area=Math.max(area,breadth*(i-k+1));
                }
                ret=Math.max(ret,area);
            }
        }
        return ret;
    }
}
