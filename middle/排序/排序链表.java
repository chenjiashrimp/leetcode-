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
    public ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        int[] nums=new int[50001];
        int size=0;
        ListNode tail=head;
        while(tail!=null){
            nums[size]=tail.val;
            tail=tail.next;
            size++;
        }
        Arrays.sort(nums,0,size);
        ListNode newHead=new ListNode(nums[0]);
        ListNode newTail=newHead;
        for(int i=1;i<size;i++){
            newTail.next=new ListNode(nums[i]);
            newTail=newTail.next;
        }
        return newHead;
    }
}
