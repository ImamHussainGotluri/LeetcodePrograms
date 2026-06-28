class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     int count=0;
        //     for(int j=i;j<n;j++){
        //         if(nums[i]==nums[j]){
        //             count++;
        //         }
        //         if(count>n/3){
        //             if(!arr.contains(nums[i])){
        //                   arr.add(nums[i]);
        //                 }
        //         }
        //     }
        // }

        // HashMap<Integer,Integer> hm=new HashMap<>();
        // for(int i=0;i<n;i++){
        //     hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        //     if(hm.get(nums[i])>n/3){
        //         if(!arr.contains(nums[i])){
        //             arr.add(nums[i]);
        //         }
        //     }
        // }

        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && ele2 != nums[i]) {
                ele1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0 && ele1 != nums[i]) {
                ele2 = nums[i];
                cnt2 = 1;
            } else if (ele1 == nums[i]) {
                cnt1++;
            } else if (ele2 == nums[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }


         cnt1=0;
         cnt2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele1){
                cnt1++;
            }

            if(nums[i]==ele2){
                cnt2++;
            }
        }

        // int mini=n/3+1;
        if (cnt1 >= n / 3+1) {
            arr.add(ele1);
        }
        if (cnt2 >= n / 3+1) {
            arr.add(ele2);
        }
        return arr;
    }
}