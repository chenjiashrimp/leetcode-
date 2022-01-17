class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int mostWater=0;
        while(l!=r){
            int water=Math.min(height[l],height[r])*(r-l);
            if(mostWater<water){
                mostWater=water;
            }
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return mostWater;
    }
}//优化的关键还是如何减少某些不可能为最终结果的情况
//这里用左右指针，如果每次都是任意移动一根，那么就是暴力遍历所有情况
//但是在这里增加了移动条件，更小的那个需要首先被移动，这就剪掉了许多不必要查看的情况
//如果移动的是大的那个，后来的容量怎么也不可能超过现在的容量，所以不需要去看

//为什么需要双指针？双指针提供了多一个的移动方向，双循环移动的都是一个方向，而两个方向的移动可以在一次循环内完成，就减小了时间复杂度
//而且可以根据大小关系减少一些不需要的遍历
