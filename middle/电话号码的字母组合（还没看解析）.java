class Solution {//这个没啥好说的，我就直接暴力了
    public List<String> letterCombinations(String digits) {
        Map<Character,String> hashtable=new HashMap<Character,String>();
        hashtable.put('2',"abc");
        hashtable.put('3',"def");
        hashtable.put('4',"ghi");
        hashtable.put('5',"jkl");
        hashtable.put('6',"mno");
        hashtable.put('7',"pqrs");
        hashtable.put('8',"tuv");
        hashtable.put('9',"wxyz");
        List<String> letters=new ArrayList<String>();
        if(digits.length()==0){
            return letters;
        }
        letters.add("");
        for(int k=0;k<digits.length();k++){
            char str=digits.charAt(k);
            List<String> list=new ArrayList<String>();
            for(int i=0;i<hashtable.get(str).length();i++){
                char digit=hashtable.get(str).charAt(i);
                for(int j=0;j<letters.size();j++){
                    list.add(letters.get(j)+digit);
                }
            }
            letters=list;
        }
        return letters;
    }
}
