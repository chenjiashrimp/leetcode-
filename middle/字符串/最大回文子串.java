class Solution {
    public String longestPalindrome(String s) {
        int maxLength=0;
        int n=s.length();
        String longest="";
        for(int i=0;i<2*n-1;i++){
            int l=i/2;
            int r=i/2+i%2;
            while(l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            maxLength=Math.max(maxLength,r-l+1);
            if(maxLength==r-l+1){
                longest=s.substring(l+1,r);
            }
        }
        return longest;
    }
}
