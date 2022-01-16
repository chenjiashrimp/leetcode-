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



class Solution {//汉明距离，一样的解法
    public int hammingDistance(int x, int y) {
        int num=x^y;
        int count=0;
        while(num>0){
            num&=num-1;
            count++;
        }
        return count;
    }
}
