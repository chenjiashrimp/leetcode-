//采用动态规划

class Solution {
    public int maxSubArray(int[] nums) {
       int pre=0;
       int maxAns=nums[0];
       for(int x:nums){
           pre=Math.max(x,pre+x);//问题的关键在于如何建立子问题（如何定义状态），然后列出状态转移方程，这里以求nums[i]为末尾的连续子数组的最大和为子问题
         //满足无后效性，有的子问题分法无法建立起方程，pre相当于阶段变量
         //pre是用滚动变量的方式进行空间优化，这样就不需要用一个数组储存之前求出的最大值，也是因为f(n)只和f(n-1)有关才能这么搞
           maxAns=Math.max(maxAns,pre);//在几个最大中挑出最大的，问题要求的和我们定义的状态有出入，因此需要多加一步
       }
       return maxAns;
    }
}


//笔记 动态规划和递归
//简单粗暴：动态规划=递归+缓存！自底向上，效率提高。动态规划是效率很高的递推方法
//依据是最优化原理：任何一个子序列都是最优决策，从头到末一直是局部最优

//贪心算法是自顶向下，不断剪枝的过程，没办法保证全局最优不被剪掉，而动态规划每一步都考虑到了各种状态

//动态规划步骤  课本例题：最短路径
//阶段划分 时间顺序和空间顺序，阶段变量
//状态 与阶段相联系，每个阶段可能有多个状态
//决策策略
//状态转移方程

//无后效性 子问题的结果不受后续阶段的影响 有向无环图


//分治法，其实也是动态规划的一种，关键在于分类讨论
class Solution {
    public int maxSubArray(int[] nums) {
       int n=nums.length;
       if(n==0){
           return 0;
       }
       return maxSubArraySum(nums,0,n-1);
    }
    public int maxCrossingSum(int[] nums,int left,int mid,int right){
        int leftSum=Integer.MIN_VALUE;
        int num=0;
        for(int i=mid;i>=left;i--){
            num+=nums[i];
            if(num>leftSum){
                leftSum=num;
            }
        }
        int rightSum=Integer.MIN_VALUE;
        num=0;
        for(int i=mid+1;i<=right;i++){
            num+=nums[i];
            if(num>rightSum){
                rightSum=num;
            }
        }
        return leftSum+rightSum;
    }
    public int maxSubArraySum(int[] nums,int left,int right){
        if(left==right){
            return nums[left];
        }
        int mid=left+(right-left)/2;
        return Math.max(maxCrossingSum(nums,left,mid,right),Math.max(maxSubArraySum(nums,left,mid),maxSubArraySum(nums,mid+1,right)));
    }
}
