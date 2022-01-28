class Solution {//模拟
    public String intToRoman(int num) {
        int[] values=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};//注意是从大排到小
        StringBuffer ans=new StringBuffer();
        for(int i=0;i<values.length;i++){
            int value=values[i];
            String symbol=symbols[i];
            while(num>=value){//相当于先确定高位，再确定低位
                num-=value;
                ans.append(symbol);
            }
            if(num==0){
                break;
            }
        }
        return ans.toString();
    }
}
