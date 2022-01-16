class Solution {
    public int singleNumber(int[] nums) {
       int res=nums[0];
       if(nums.length>1){
           for(int i=1;i<nums.length;i++){
               res=res^nums[i];//异或运算太牛逼了
           }
       }
       return res;
    }
}
//异或：不同为0，相同为1
//异或满足交换律 A^B^B=A这是个有用的性质
//0异或任何一个数，数不变
