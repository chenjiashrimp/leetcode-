class Solution {//
    public int[] countBits(int n) {
        int[] ones=new int[n+1];
        for(int i=0;i<=n;i++){
            ones[i]=countOnes(i);
        }
        return ones;
    }
    public int countOnes(int x){//Brian Kernighan 算法
        int num=0;
        while(x>0){
            x=x&(x-1);
            num++;
        }
        return num;
    }
}
