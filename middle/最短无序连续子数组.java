class Solution {//考虑反面
    public int findUnsortedSubarray(int[] nums) {
        if(isSorted(nums)){
            return 0;
        }
        int n=nums.length;
        int[] numsSorted=new int[n];
        System.arraycopy(nums,0,numsSorted,0,n);
        Arrays.sort(numsSorted);
        int left=0,right=n-1;
        while(nums[left]==numsSorted[left]){
            left++;
        }
        while(numsSorted[right]==nums[right]){
            right--;
        }
        return right-left+1;
    }
    public boolean isSorted(int[] nums){
        if(nums.length==0){
            return true;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                return false;
            }
        }
        return true;
    }
}
