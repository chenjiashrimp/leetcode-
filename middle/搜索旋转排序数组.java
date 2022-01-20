class Solution {//虽然不是完全升序，但是依然可以用二分法，分析思路时懂得分类讨论就能看出来
    public int search(int[] nums, int target) {
        int n=nums.length;
        if(n==0){
            return -1;
        }
        if(n==1){
            return nums[0]==target?0:-1;
        }//特殊情况
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }//不要光记得写二分，这个给忘了
            if(nums[mid]>=nums[0]){
                if(nums[0]<=target&&target<nums[mid]){//要不要等于号呢，需要仔细考虑
                  //这个用0不用l也可以
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(nums[mid]<target&&target<=nums[n-1]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
