class Solution {//依然是01背包问题
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        if(n<2){
            return false;
        }
        int sum=0,maxNum=0;
        for(int num:nums){
            sum+=num;
            maxNum=Math.max(maxNum,num);
        }
        if(sum%2!=0){//一定要记得先排除掉部分情况
            return false;
        }
        int target=sum/2;
        if(maxNum>target){
            return false;
        }
        boolean[][] f=new boolean[n][target+1];//数组的类型
        for(int i=0;i<n;i++){
            f[i][0]=true;
        }
        f[0][nums[0]]=true;//考虑好边界问题，其他的初始化就是false不用改
        for(int i=1;i<n;i++){
            int num=nums[i];
            for(int j=1;j<=target;j++){
                if(j>=num){
                    f[i][j]=f[i-1][j]||f[i-1][j-num];
                }else{
                    f[i][j]=f[i-1][j];
                }
            }
        }
        return f[n-1][target];
    }
}
