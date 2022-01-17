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
class Solution {//没什么方法，就最简单原始地来，我一开始错在了特殊情况
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){//空表
            return null;
        }
        ListNode tail=head;
        int length=1;
        while(tail.next!=null){
            tail=tail.next;
            length++;
        }
        if(n==length){//删除第一个，这两个特殊情况一开始被我忽略
            return head.next;
        }
        tail=head;
        int i=length-n-1;
        while(i>0){
            tail=tail.next;
            i--;
        }
        tail.next=tail.next.next;
        return head;
    }
}
