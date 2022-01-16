/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
       ListNode currentHead=head;
       List<Integer> vals=new ArrayList<Integer>();
       while(currentHead!=null){
           vals.add(currentHead.val);
           currentHead=currentHead.next;
       }
       int front=0;
       int back=vals.size()-1;
       while(front<back){
           if(!vals.get(front).equals(vals.get(back))){
               return false;
           }
           front++;
           back--;
       }
       return true;
    }
}
//回顾List，其实和map与set一样，都是java的数据结构
//List又分成LinkedList和ArrayList，LinkedList就是链表，但是ArrayList可不是数组，从它的各种method来看，它其实更像链表一点，但是在cs61B，我们又知道它内部是借助数组实现的
//与其有关的method
//.size() .add() .get(下标) 可以用下标和数组像 .equals()
