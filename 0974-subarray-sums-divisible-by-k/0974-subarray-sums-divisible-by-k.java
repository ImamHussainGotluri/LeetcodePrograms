class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     int sum=0;
        //     for(int j=i;j<n;j++){
        //         sum+=nums[j];
        //         if(sum==k){
        //             cnt++;
        //         }
        //     }
        // }

       int cnt=0;
       Map<Integer,Integer> hm=new HashMap<>();
       hm.put(0,1);
       int sum=0;
       for(int i=0;i<nums.length;i++){
          sum+=nums[i];
          int div=(sum%k+k)%k;
          if(hm.containsKey(div)){
              cnt+=hm.get(div);
          }
          hm.put(div,hm.getOrDefault(div,0)+1);
       }
       return cnt;
    }
}