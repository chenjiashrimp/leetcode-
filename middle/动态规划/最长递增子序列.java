class Solution {
    public int lengthOfLIS(int[] nums) {
        int longest=0;
        int n=nums.length;
        if(n==1){
            return 1;
        }
        int[] f=new int[n];
        f[0]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    f[i]=Math.max(f[i],f[j]+1);
                }else{
                    f[i]=Math.max(f[i],1);
                }
            }
            longest=Math.max(longest,f[i]);
        }
        return longest;
    }
}
