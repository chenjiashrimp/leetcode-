class Solution {//还是滚动变量，但是因此减小了可读性
    public int climbStairs(int n) {
        int r=1,q=0,p=0;
        for(int i=1;i<=n;i++){
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }
}
