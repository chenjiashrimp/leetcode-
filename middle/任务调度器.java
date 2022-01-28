class Solution {//关键在于如何构造出花费时间最小的模型，没有涉及什么复杂的算法。涉及到数据结构的运用
  //通过分类讨论、先特殊后一般得到模型
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freq=new HashMap<Character,Integer>();
        int maxExec=0;
        for(char ch:tasks){
            int exec=freq.getOrDefault(ch,0)+1;
            freq.put(ch,exec);
            maxExec=Math.max(exec,maxExec);
        }
        int maxCount=0;
        Set<Map.Entry<Character,Integer>> entrySet=freq.entrySet();
        for(Map.Entry<Character,Integer> entry:entrySet){
            int value=entry.getValue();
            if(value==maxExec){
                maxCount++;
            }
        }
        return Math.max(tasks.length,(maxExec-1)*(n+1)+maxCount);
    }
}
