class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n-k];




    //      PriorityQueue<Integer> pq=new PriorityQueue<>();
    //    for(int i=0;i<nums.length;i++){
    //     pq.add(nums[i]);
    //    }
    //    for(int i=0;i<k;i++){
    //     if(i+1==k){
    //         return pq.poll();
    //     }
    //     pq.poll();
    //    }
    //    return 0;


    // for(int i=0;i<nums.length;i++){
    //     int temp=nums[i];
    //     pq.add(temp);
    //     if(pq.size()>k){
    //         pq.poll();
    //     }
    // }
    // return pq.poll();
    // }
    }
}