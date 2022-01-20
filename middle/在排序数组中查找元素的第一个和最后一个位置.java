class Solution {//还是用二分法，但是想出来要这么写挺难的
    public int[] searchRange(int[] nums, int target) {
        int left=BinarySearch(nums,target,true);
        int right=BinarySearch(nums,target,false)-1;
        if(left<=right&&right<nums.length&&nums[left]==target&&nums[right]==target){
            return new int[]{left,right};
        }
        return new int[]{-1,-1};
    }
    public int BinarySearch(int[] nums,int target, boolean x){//这是为了简化，其实也可以写两个函数
        int left=0;
        int right=nums.length-1;
        int ans=nums.length;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>target||(x&&nums[mid]>=target)){
                right=mid-1;
                ans=mid;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}
