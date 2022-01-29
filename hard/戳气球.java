class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][] rec=new int[n+2][n+2];注意定义的子状态，i j是开区间
        int[] val=new int[n+2];
        val[0]=val[n+1]=1;//拓宽边界
        for(int i=0;i<n;i++){
            val[i+1]=nums[i];
        }
      //注意边界状态i<j-1中间至少需要一个数，一个数也没有那就是0了，刚好数组初始化就是0
        for(int i=n-1;i>=0;i--){//要注意开始的顺序
            for(int j=i+2;j<=n+1;j++){
                for(int k=i+1;k<j;k++){
                    int sum=val[i]*val[k]*val[j];
                    sum+=rec[i][k]+rec[k][j];
                    rec[i][j]=Math.max(rec[i][j],sum);
                }
            }
        }
        return rec[0][n+1];
    }
}
