class Solution {//这道题的时间复杂度要求是对数，这里没有实现
  //用双指针排序合并的方法要记清楚了
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[] newArray=new int[n1+n2];
        int index1=0;
        int index2=0;
        int size=0;
        while(index1<n1||index2<n2){
           if(index1==n1){
               newArray[size]=nums2[index2];
               index2++;
           }
           else if(index2==n2){
               newArray[size]=nums1[index1];
               index1++;
           }
           else{
               if(nums1[index1]<nums2[index2]){
                   newArray[size]=nums1[index1];
                   index1++;
               }else{
                   newArray[size]=nums2[index2];
                   index2++;
               }
           }
           size++;
        }
        if((n1+n2)%2==1){
            return newArray[(n1+n2)/2];
        }else{
            return (newArray[(n1+n2-1)/2]+newArray[((n1+n2-1)/2)+1])/2.0;
        }
    }
}
