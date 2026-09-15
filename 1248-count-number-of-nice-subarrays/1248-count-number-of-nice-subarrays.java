class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // return helper(nums,k)-helper(nums,k-1);

        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int sum=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]%2!=0?1:0;

            if(hm.containsKey(sum-k)){
                cnt+=hm.get(sum-k);
            }

            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }

        return cnt;
    }
    // public int helper(int arr[],int k){
    //     int cnt=0;
    //     int l=0;
    //     int ans=0;
    //     for(int r=0;r<arr.length;r++){

    //         if(arr[r]%2!=0){
    //             cnt++;
    //         }

    //         while(cnt>k){
    //             if(arr[l]%2!=0){
    //                 cnt--;
    //             }
    //             l++;
    //         }

    //         ans+=r-l+1;
    //     }
    //     return ans;
    // }
}