class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>  occurrence=new HashMap<Integer,Integer>();
        for(int num:nums){
            occurrence.put(num,occurrence.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>(){//优先队列
            public int compare(int[] m,int[] n){
                return m[1]-n[1];
            }
        });
        for(Map.Entry<Integer,Integer> entry:occurrence.entrySet()){
            int num=entry.getKey();
            int count=entry.getValue();
            if(queue.size()==k){
                if(queue.peek()[1]<count){
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else{
                queue.offer(new int[]{num,count});
            }
        }
        int[] ret=new int[k];
        for(int i=0;i<k;i++){
            ret[i]=queue.poll()[0];
        }//任意顺序输出皆可
        return ret;
    }
}
