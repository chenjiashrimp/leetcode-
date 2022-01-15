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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }else if(list1.val>list2.val){
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }else{
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }

    }//条件怎么写和return什么，在哪里return可能是易错点
}//这类题做不出来的关键是没有想到能用递归，还是要养成条件反射，思考有没有办法化简为更简单的问题，可不可以用递归
