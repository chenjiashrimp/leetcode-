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
//做链表题的两个总结
//一定要多设变量，不然你会被指针的位置搞乱
//head需要改变的时候，不妨在一开始设置一个假head，最后直接返回head.next
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        while(cur.next!=null&&cur.next.next!=null){//关于空指针的检测需要注意
            int x=cur.next.val;//因为这个是排序链表所以一次遍历就可以了要注意审题
            if(cur.next.val==cur.next.next.val){
                 while(cur.next!=null&&cur.next.val==x){//这里还要检测一次，因为又是一个循环
                     cur.next=cur.next.next;
                 }
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
