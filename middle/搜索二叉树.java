class Solution {//动态规划，主要是理解题意
    public int numTrees(int n) {
        int[] G=new int[n+1];
        G[0]=1;
        G[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<=i-1;j++){
                G[i]+=G[j]*G[i-1-j];
            }
        }
        return G[n];
    }
}
