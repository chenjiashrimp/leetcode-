class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        if(n==1){
            return triangle.get(0).get(0);
        }
        int[][] f=new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                if(i==n-1){
                    f[i][j]=triangle.get(i).get(j);
                }else{
                    f[i][j]=triangle.get(i).get(j)+Math.min(f[i+1][j],f[i+1][j+1]);
                }
            }
        }
        return f[0][0];
    }
}
