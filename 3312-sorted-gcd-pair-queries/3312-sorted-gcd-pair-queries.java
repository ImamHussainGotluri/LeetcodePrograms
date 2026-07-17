class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n=nums.length;
        int maxVal=0;
        for(int num:nums){
            maxVal=Math.max(maxVal,num);
        }

        int freq[]=new int[maxVal+1];
        for(int i=0;i<n;i++){
            int num=nums[i];
            for(int j=1;j*j<=num;j++){
                if(num%j==0){
                    freq[j]++;
                    if(num/j!=j){
                        freq[num/j]++;
                    }
                }
            }
        }

        long pairWithGcd[]=new long[maxVal+1];
        for(int g=maxVal;g>=1;g--){
            long count=freq[g];
            pairWithGcd[g]=count*(count-1)/2;

            for(int multi=2*g;multi<=maxVal;multi+=g){
                pairWithGcd[g]-=pairWithGcd[multi];
            }
        }

        long pairCountGcd[]=new long[maxVal+1];
        for(int i=1;i<=maxVal;i++){
            pairCountGcd[i]=pairCountGcd[i-1]+pairWithGcd[i];
        }

        int m=queries.length;
        int res[]=new int[m];
        int j=0;
        for(long idx:queries){
            int l=1;
            int r=maxVal;
            int temp=1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(pairCountGcd[mid]>=idx+1){
                    temp=mid;
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            res[j++]=temp;
        }
        return res;
    }
}