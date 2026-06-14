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
        List<Integer> arr=new ArrayList<>();
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }
        int l=0;
        int r=arr.size()-1;
        int max=Integer.MIN_VALUE;
        while(l<r){
            max=Math.max(max,arr.get(l)+arr.get(r));
            l++;
            r--;
        }
        return max;
    }
}