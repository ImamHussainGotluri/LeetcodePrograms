class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        // for(int i=0;i<n-2;i++){
        //     for(int j=i+1;j<n-1;j++){
        //         for(int k=j+1;k<n;k++){
        //             ArrayList<Integer> sub=new ArrayList<>();
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 sub.add(nums[i]);
        //                 sub.add(nums[j]);
        //                 sub.add(nums[k]);
        //                 Collections.sort(sub);
        //                 if(!res.contains(sub)){
        //                  res.add(sub);
        //                 }
        //             }
        //         }
        //     }
        // }

    //    for(int i=0;i<n;i++){
    //         HashSet<Integer> hs=new HashSet<>();
    //         for(int j=i+1;j<n;j++){
    //             int k=0-(nums[i]+nums[j]);
    //             if(hs.contains(k)){
    //                 List<Integer> ans=new ArrayList<>();
    //                 ans.add(nums[i]);
    //                 ans.add(nums[j]);
    //                 ans.add(k);
    //                 Collections.sort(ans);
    //                 if(!res.contains(ans)){
    //                     res.add(ans);
    //                 }
    //             }
    //             hs.add(nums[j]);
    //         }
    //     }

        Arrays.sort(nums);
        for(int i=0;i<n;i++){

            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];

                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else{
                    List<Integer> ans=new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);
                    res.add(ans);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }

                    while(j<k && nums[k]==nums[k+1]){
                        k--;
                    }
                }
            }
        }

        return res;
    }
}