class Solution {//还是二分法
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        if(n==0){//注意考虑特殊情况
            return false;
        }
        if(n==1){
            return nums[0]==target;
        }
        int l=0;
        int r=n-1;
        int mid=(l+r)/2;
        while(l<=r){
            mid=(l+r)/2;//写在循环里面
            if(nums[mid]==target){
                return true;
            }
            if(nums[l]==nums[mid] && nums[mid]==nums[r]){//注意这种特殊情况，无法判断那一边数组是有序的
                l++;
                r--;
            }else if(nums[l]<=nums[mid]){
                if(nums[l]<=target&&target<nums[mid]){//等号需要注意
                    r=mid-1;//和r=mid--可是完全不一样
                }else{
                    l=mid+1;
                }
            }else{
                if(nums[mid]<target&&target<=nums[n-1]){//这里是n-1不是r
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return false;
    }
}
