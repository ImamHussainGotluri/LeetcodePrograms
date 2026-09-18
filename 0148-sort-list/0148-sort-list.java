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
        if(head==null || head.next==null){
            return head;
        }

        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=null;
        ListNode list1=head;
        ListNode list2=slow;

        ListNode head1=sortList(list1);
        ListNode head2=sortList(list2);

        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(head1!=null && head2!=null){
            if(head1.val <= head2.val){
                curr.next=head1;
                head1=head1.next;
            }
            else{
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }

        if(head1!=null){
            curr.next=head1;
        }

        if(head2!=null){
            curr.next=head2;
        }

        return dummy.next;
    }
}