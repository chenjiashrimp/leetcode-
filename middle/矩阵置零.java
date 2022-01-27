class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean[] line=new boolean[n];
        boolean[] row=new boolean[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    line[i]=row[j]=true;
                }
            }//一开始犯了错误，后面置零的数引发了新一轮的置零，所以需要先遍历一边确定最开始为0的元素
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(line[i]||row[j]){//注意写法，有一个为true就行了
                    matrix[i][j]=0;
                }
            }
        }
        return;
    }
}
