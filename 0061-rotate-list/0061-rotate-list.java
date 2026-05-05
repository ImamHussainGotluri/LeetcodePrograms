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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
       ListNode temp=head;
       ListNode prevhead=head;
       ListNode mover=head;
       ListNode lastnode=head;
       ListNode before=null;
       int len=0;
       while(mover!=null){
        len++;
        mover=mover.next;
       }
       if(k==len){
        return head;
       }
       int sl=k%len;
       if(sl==0){
        return head;
       }
       while(temp.next!=null){
          len--;
          before=temp;
          temp=temp.next;
          if(sl==len){
           head=temp;
           lastnode=before;
          }
       }
       temp.next=prevhead;
       lastnode.next=null;
        return head;
    }
}