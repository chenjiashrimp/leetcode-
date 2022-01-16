class Solution {//注意审题就行，最大值为n不需要您亲自去算
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int max=0;
        int n=nums.length;
        List<Integer> numbers=new ArrayList<Integer>();
        int[] missing=new int[n+1];
        for(int i=0;i<n;i++){
            missing[nums[i]]=1;
        }
        for(int i=1;i<=n;i++){
            if(missing[i]==0){
                numbers.add(i);
            }
        }
        return numbers;
    }
}
