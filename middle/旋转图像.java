class Solution {//只要清楚旋转后坐标和旋转前坐标的数量关系就可以啦
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] rotateMatrix=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rotateMatrix[j][n-i-1]=matrix[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=rotateMatrix[i][j];
            }
        }
    }
}
