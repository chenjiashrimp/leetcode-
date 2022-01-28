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
    public ListNode rotateRight(ListNode head, int k) {//没什么特别的方法主要是注意细节，考虑特殊情况，指针移动要移动多少位
        if(k==0||head==null||head.next==null){//注意条件的顺序
            return head;
        }
        ListNode iter=head;
        int n=1;
        while(iter.next!=null){
            iter=iter.next;
            n++;
        }
        int add=n-k%n;
        if(add==n){
            return head;
        }
        iter.next=head;
        while(add-->0){
            iter=iter.next;
        }
        ListNode ret=iter.next;
        iter.next=null;
        return ret;
    }
}
