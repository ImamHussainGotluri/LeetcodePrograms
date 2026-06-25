class Solution {
    public int majorityElement(int[] nums) {
        // for(int i=0;i<nums.length;i++){
        //     int count=0;
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             count++;
        //         }
        //     }
        //      if(count>nums.length/2){
        //             return nums[i];
        //         }
        // }
        // return -1;

        // HashMap<Integer,Integer> hm=new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        //     if(hm.get(nums[i])>nums.length/2){
        //         return nums[i];
        //     }
        // }
        // return -1;

        int cnt=0;
        int ele=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele){
                cnt++;
            }
            else{
                cnt--;
                if(cnt<=0){
                    ele=nums[i];
                    cnt=1;
                }
            }
        }
        return ele;
    }
}