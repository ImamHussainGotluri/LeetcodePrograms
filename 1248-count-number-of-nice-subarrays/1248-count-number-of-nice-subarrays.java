class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int arr[],int k){
        int cnt=0;
        int l=0;
        int ans=0;
        for(int r=0;r<arr.length;r++){

            if(arr[r]%2!=0){
                cnt++;
            }

            while(cnt>k){
                if(arr[l]%2!=0){
                    cnt--;
                }
                l++;
            }

            ans+=r-l+1;
        }
        return ans;
    }
}