class Solution {//动态规划，但是状态转移方程不好想
    public boolean isMatch(String s, String p) {
        int ls=s.length();
        int lp=p.length();
        boolean[][] f=new boolean[ls+1][lp+1];//子状态：s的前i个能匹配到p的前j个
        f[0][0]=true;//注意特殊值初始化
        for(int i=0;i<=ls;i++){
            for(int j=1;j<=lp;j++){
                if(p.charAt(j-1)=='*'){//注意i,j不同的含义因此有时要用到j-1
                    f[i][j]=f[i][j-2];
                    if(match(s,p,i,j-1)){
                        f[i][j]=f[i][j]||f[i-1][j];//这一步特别难想，我暂时找不到切入口
                    }
                }else{
                    if(match(s,p,i,j)){
                        f[i][j]=f[i-1][j-1];
                    }
                }
            }
        }
        return f[ls][lp];
    }
    public boolean match(String s,String p,int i,int j){
        if(i==0){//依然是特殊情况
            return false;
        }
        if(p.charAt(j-1)=='.'){
            return true;
        }
        return s.charAt(i-1)==p.charAt(j-1);
    }
}
