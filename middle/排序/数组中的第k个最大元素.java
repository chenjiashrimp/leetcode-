class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int num:nums){
           int currentsize=queue.size();
           if(currentsize==k){
               if(num>queue.peek()){
                   queue.poll();
                   queue.offer(num);
               }
           }else{
               queue.offer(num);
           }
        }
        return queue.peek();
    }
}
