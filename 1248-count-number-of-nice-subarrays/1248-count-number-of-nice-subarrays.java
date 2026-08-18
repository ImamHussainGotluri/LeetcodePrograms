class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
    //    int res=atmost(nums,k)-atmost(nums,k-1);
    //         return res;
    // }

    // public static int atmost(int nums[],int k){
    //     int l=0;
    //     int ans=0;int temp=0;
    //     for(int r=0;r<nums.length;r++){
    //         if(nums[r]%2!=0){
    //             temp++;
    //         }
    //         while(temp>k){
    //             if(nums[l]%2!=0){
    //                 temp--;
    //             }
    //             l++;
    //         }
    //         ans+=r-l+1;
    //     }
    //     return ans;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                nums[i]=1;
            }
            else{
                nums[i]=0;
            }
        }
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int sum=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hm.containsKey(sum-k)){
                cnt+=hm.get(sum-k);
            }

            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}