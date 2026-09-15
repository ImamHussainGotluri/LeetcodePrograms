class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n=nums.size();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            int val=nums.get(i);

            if(val%modulo==k){
                arr[i]=1;
            }
            else{
                arr[i]=0;
            }
        }

        int sum=0;
        Map<Integer,Long> hm=new HashMap<>();
        hm.put(0,1L);
        long cnt=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            sum=sum%modulo;

            if(hm.containsKey((sum-k+modulo)%modulo)){
                cnt+=hm.get((sum-k+modulo)%modulo);
            }

            hm.put(sum,hm.getOrDefault(sum,0L)+1);
        }
        return cnt;
    }
}