class Solution {//动态规划的思路是对的，但是被负数的情况卡住了，再多一个数组算最小值就行了
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int[] maxvalue=new int[n];
        int[] minvalue=new int[n];
        System.arraycopy(nums,0,maxvalue,0,n);
        System.arraycopy(nums,0,minvalue,0,n);
        for(int i=1;i<n;i++){
            maxvalue[i]=Math.max(maxvalue[i-1]*nums[i],Math.max(minvalue[i-1]*nums[i],maxvalue[i]));
            minvalue[i]=Math.min(minvalue[i-1]*nums[i],Math.min(maxvalue[i-1]*nums[i],minvalue[i]));
        }
        int ans=maxvalue[0];
        for(int i=0;i<n;i++){
            ans=Math.max(ans,maxvalue[i]);
        }
        return ans;
    }
}
