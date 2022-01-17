class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ=new HashSet<Character>();
        int rk=-1;
        int n=s.length();
        int res=0;
        for(int i=0;i<n;i++){
            if(i!=0){
                occ.remove(s.charAt(i-1));
            }
            while(rk+1<n&&!occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                rk++;
            }
            res=Math.max(res,rk-i+1);
        }//运用滑动窗口，子串的子串必然也是没有重复的，相交的那段子串必然是无重复的，所以不用再次检测
        return res;
    }
}
//一开始想用动态规划，但是状态转移方程没办法列出，而且子状态也找不对

//这种找子串之类的东西，首先要明确子串的数目很大，如果暴力的话需要把每一条都看一遍，时间复杂度就高了
//如何降低时间复杂度呢？重要的是把子串分类，需要找到一个分类的点，这样一次可以筛选完一类子串，时间复杂度就降下来了。
//比如这道题就从子串的首字符进行分类，要寻找不同类之间的联系
