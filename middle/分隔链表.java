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
class Solution {//思路简单，就是分成两个链表
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0);
        ListNode smallhead=small;//哑节点，为了处理空链表的情况
        ListNode large=new ListNode(0);
        ListNode largehead=large;
        while(head!=null){
            if(head.val<x){
                small.next=head;
                small=small.next;
            }else{
                large.next=head;
                large=large.next;
            }
            head=head.next;
        }
        large.next=null;
        small.next=largehead.next;//一定要注意四个指针分别的位置，别搞错了！
        return smallhead.next;
    }
}
