class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int[] zeros=new int[n];
        int zeroNums=0;
        zeros[0]=0;
        for(int i=1;i<n;i++){
            if(nums[i-1]==0){
                zeroNums++;
            }
            zeros[i]=zeroNums;//一开始把这行式子弄到括号里面去了
        }
        if(nums[n-1]==0){
            zeroNums++;//细节，最后一位也要统计进去，不然最后一个循环出现问题
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[i-zeros[i]]=nums[i];
            }
        }
        for(int i=n-zeroNums;i<n;i++){
            nums[i]=0;
        }
        return;
    }
}
