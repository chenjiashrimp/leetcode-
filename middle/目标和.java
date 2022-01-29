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


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }
}//优化
//由于 \textit{dp}dp 的每一行的计算只和上一行有关，因此可以使用滚动数组的方式，去掉 \textit{dp}dp 的第一个维度，将空间复杂度优化到 O(\textit{neg})O(neg)。
//实现时，内层循环需采用倒序遍历的方式，这种方式保证转移来的是 \textit{dp}[i-1][]dp[i−1][] 中的元素值。
