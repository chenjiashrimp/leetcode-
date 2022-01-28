class Solution {//动态规划，没什么好说的
    public int numSquares(int n) {
        int[] f=new int[n+1];
        for(int i=1;i<n+1;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                min=Math.min(min,f[i-j*j]);
            }
            f[i]=min+1;
        }
        return f[n];
    }
}
