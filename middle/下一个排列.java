class Solution {//没有什么特别的技巧，能理清整个思路，代码就能写出来，思路的关键在于如何找出下一个更大的数
  //首先，由于是数组内部的数字自行调换，所以必然涉及进位，所以我们需要先找出进的哪一位（如何判断：如果一个数它最高位以外的数字呈升序排列，那么整个数已经是该位状态下的最大数字了）
  //接下来要找哪个数字和它换，进位前面的位数都没必要管，那么就是从进位后面找一个比该位大的最小数。
  //进位完之后，我们需要把该位后面的数字调成升序，这是为了满足“下一个更大”的条件。
  //知道思路代码就能写了，最后注意一些细节，比如数组长度和不存在更大的数了
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        int j=nums.length-1;
        if(i>=0){
            while(nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int[] nums,int start){//因为是降序改成升序，因此reverse就行了不需要重新排序
        int end=nums.length-1;
        while(start<=end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}
