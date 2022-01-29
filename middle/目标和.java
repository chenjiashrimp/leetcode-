class Solution {//01背包问题，题解和我思路一样
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int diff=sum-target;
        if(diff<0||diff%2!=0){
            return 0;//先排除一部分
        }
        int n=nums.length,neg=diff/2;//neg的意思是取负号的元素的和，因为sum固定，target固定所以neg也是固定的，因此j的含义是neg还是target都不影响解题
        int[][] f=new int[n+1][neg+1];
        f[0][0]=1;
        for(int i=1;i<=n;i++){
            int num=nums[i-1];
            for(int j=0;j<=neg;j++){
                f[i][j]=f[i-1][j];
                if(j>=num){
                    f[i][j]+=f[i-1][j-num];
                }
            }
        }
        return f[n][neg];
    }
}
