class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n=arr.length;
        // int cnt=n/2;
        // if(n%2!=0){
        //     return false;
        // }
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if((arr[i]+arr[j])%k==0){
        //             cnt--;
                    
        //         }
        //         if(cnt==0){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        int res[]=new int[k];
        for(int val:arr){
            int temp=(val%k+k)%k;

            res[temp]++;
        }

        if(res[0]%2!=0){
            return false;
        }

        for(int i=1;i<k;i++){
            if(res[i]!=res[k-i]){
                return false;
            }
        }
        return true;
    }
}