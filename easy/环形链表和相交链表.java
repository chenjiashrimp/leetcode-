public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen=new HashSet<ListNode>();
        while(head!=null){
            if(!seen.add(head)){
                return true;
            }
            head=head.next;
        }
        return false;
    }
}//使用set，重复性问题


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> cross=new HashSet<ListNode>();
        while(headA!=null){
            cross.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(!cross.add(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}
