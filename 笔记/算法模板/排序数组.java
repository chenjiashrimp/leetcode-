class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        quickSort(nums,0,n-1);
        return nums;
    }
    public void quickSort(int[] nums,int l,int r){
        if(l>=r){
            return;
        }
        int i=l,j=r;
        int temp=nums[i];
        while(i!=j){
            while(j>i&&nums[j]>temp){
                j--;
            }
            if(j>i){
                nums[i++]=nums[j];
            } 
            while(j>i&&nums[i]<temp){
                i++;
            }
            if(i<j){
                nums[j--]=nums[i];
            }
        }
        nums[i]=temp;
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }
}
