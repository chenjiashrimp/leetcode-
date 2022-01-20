class Solution {//这类题都像是小学奥数题，实现过程不存在没学过的东西，解题的关键在于找出规律
    public boolean canJump(int[] nums) {//如果某个起跳点可以跳n格，那么其右边n格能够作为新的起跳点，按照这条规律一直推下去，如果最后一格也能成为起跳点那就能到
        int maxjump=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxjump){
                return false;
            }
            maxjump=Math.max(maxjump,i+nums[i]);
        }
        return true;
    }
}
