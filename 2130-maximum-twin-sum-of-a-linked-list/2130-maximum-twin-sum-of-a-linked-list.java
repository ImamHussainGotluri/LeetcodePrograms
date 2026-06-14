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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode end=rev(slow);
        int max=Integer.MIN_VALUE;
        while(head!=null || end!=null){
            max=Math.max(max,head.val+end.val);
            head=head.next;
            end=end.next;
        }
        return max;
    }
    public ListNode rev(ListNode head){
            if(head==null || head.next==null){
            return head;
        }
       ListNode prev=null;
       ListNode temp=head.next;
       while(temp!=null){
        head.next=prev;
        prev=head;
        head=temp;
        temp=temp.next;
       }
       head.next=prev;
       return head;
    }
}








// List<Integer> arr=new ArrayList<>();
        // while(head!=null){
        //     arr.add(head.val);
        //     head=head.next;
        // }
        // int l=0;
        // int r=arr.size()-1;
        // int max=Integer.MIN_VALUE;
        // while(l<r){
        //     max=Math.max(max,arr.get(l)+arr.get(r));
        //     l++;
        //     r--;
        // }
        // return max;