class Solution {
    public String convert(String s, int numRows) {
        String newS="";
        int length=s.length();
        if(numRows==1){
            return s;
        }
        for(int i=0;i<numRows;i++){
            int j=i;
            if(i==0||i==numRows-1){
                while(j<length){
                    newS+=s.charAt(j);
                    j+=2*numRows-2;
                }
            }else{
                while(j<length){
                    newS+=s.charAt(j);
                    j+=(2*numRows-2)-2*i;
                    if(j<length){
                        newS+=s.charAt(j);
                        j+=2*i;
                    }
                }
            }
        }
        return newS;
    }
}
