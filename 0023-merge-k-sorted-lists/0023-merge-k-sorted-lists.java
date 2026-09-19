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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }

        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        
        for(int i=0;i<lists.length;i++){
            ListNode curr=lists[i];
            while(curr!=null){
                pq.add(curr);
                curr=curr.next;
            }
        }

        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(!pq.isEmpty()){
            curr.next=pq.poll();
            curr=curr.next;
        }
        curr.next=null;

        return dummy.next;
    }
}