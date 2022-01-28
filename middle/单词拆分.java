class Solution {//依然为动态规划
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet<String>(wordDict);//把单词搞到set里，注意构造函数
        int n=s.length();
        boolean[] f=new boolean[n+1];
        f[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(f[j]&&wordDictSet.contains(s.substring(j,i))){//子串
                    f[i]=true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
