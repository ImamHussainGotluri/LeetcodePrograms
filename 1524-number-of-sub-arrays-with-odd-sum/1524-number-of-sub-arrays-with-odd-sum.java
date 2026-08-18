class Solution {
    int mod=1000000007;
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        Map<Integer,Long> hm=new HashMap<>();
        hm.put(0,1L);
        int k=2;
        long sum=0;
        long cnt=0;
        long total=(long)n*(n+1)/2;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int div=(int)(sum%k+k)%k;
            if(hm.containsKey(div)){
                cnt=(cnt+hm.get(div))%mod;
            }
            hm.put(div,hm.getOrDefault(div,0L)+1L);
        }
        long ans=(total-cnt)%mod;
        if(ans<0){
            ans+=mod;
        }
        return (int)ans;
    }
}