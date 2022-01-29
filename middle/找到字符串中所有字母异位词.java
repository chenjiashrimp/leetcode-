class Solution {//因为异位词长度一致，考虑使用滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        int slen=s.length(),plen=p.length();
        if(slen<plen){
            return new ArrayList<Integer>();
        }
        List<Integer> ans=new ArrayList<Integer>();
        int[] scount=new int[26];
        int[] psount=new int[26];
        for(int i=0;i<plen;i++){
            scount[s.charAt(i)-'a']++;
            psount[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(scount,psount)){
            ans.add(0);
        }
        for(int i=0;i<slen-plen;i++){
            scount[s.charAt(i)-'a']--;
            scount[s.charAt(i+plen)-'a']++;
            if(Arrays.equals(scount,psount)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
