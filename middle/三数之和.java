// 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

// 注意：答案中不可以包含重复的三元组。





//两数之和的升级版，复杂了很多
//简单暴力的自然是三重循环，可以先从最暴力原始的方法出发，再想办法优化
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        int n=nums.length;
        Arrays.sort(nums);//给数组排序的函数，记住，别写错了
        for(int first=0;first<n;first++){
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            int target=-nums[first];
            int third=n-1;
            for(int second=first+1;second<n;second++){//这里又用到左右指针的思路，把本来的三重循环降为二重，当然了，也是因为第二第三个数存在数量关系，二大了三就要小，根据这个关系
              //可以用指针直接排除掉第三个数字不可能成立的情况
                if(second>first+1&&nums[second]==nums[second-1]){//同上
                    continue;
                }//避免重复，因为排序过了所以只需要比较相邻两个
                while(nums[second]+nums[third]>target){
                    third--;
                    if(third<=second){
                        break;
                    }
                }
                if(third<=second){//这里考虑欠妥，third不是==second才不行，小于也不行，为了避免重复我们首先要排序确定三个数大小顺序，这在很多题都见过
                    break;
                }
                if(nums[second]+nums[third]<target){
                    continue;
                }
                if(nums[second]+nums[third]==target){
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
