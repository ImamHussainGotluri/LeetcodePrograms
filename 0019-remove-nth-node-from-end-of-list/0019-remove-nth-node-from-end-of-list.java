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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if(head==null || head.next==null){
        //     return null;
        // }
        // ListNode temp=head;
        // int len=0;
        // ListNode prev=null;
        // while(temp!=null){
        //     len++;
        //     prev=temp;
        //     temp=temp.next;
        // }
        // if(len==n){
        //     return head.next;
        // }
    
        // ListNode ans=head;
        // int cnt=len-n;
        // ListNode mover=head;
        // while(mover!=null){
        //     cnt--;
        //     if(cnt==0){
        //         break;
        //     }
        //     mover=mover.next;
        // }
        // mover.next=mover.next.next;
        // return ans;

        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }

        if(fast==null){
            return head.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head; 
    }
}