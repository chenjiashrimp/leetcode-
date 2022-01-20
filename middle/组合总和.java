class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        List<Integer> digits=new ArrayList<Integer>();
        Arrays.sort(candidates);
        selectNumbers(list,digits,candidates,target,candidates.length-1);
        return list;
    }
    public void selectNumbers(List<List<Integer>> list,List<Integer> digits, int[] candidates,int target,int index){
        if(target==0){
            list.add(new ArrayList(digits));//这里我一开始直接add(digits)结果输出显示的是空数组，我推测应该是指针的关系，add应该算是浅层复制，所以我后面删除digits的元素，list里面的也会跟着删除
            return;
        }
        for(int i=index;i>=0;i--){
            if(candidates[i]>target){
                continue;
            }
            digits.add(candidates[i]);
            selectNumbers(list,digits,candidates,target-candidates[i],i);
            digits.remove(digits.size()-1);
        }
        return;
    }
}
