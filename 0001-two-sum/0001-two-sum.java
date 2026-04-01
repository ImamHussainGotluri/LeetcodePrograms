class Solution {
    public int[] twoSum(int[] nums, int target) {
         int[] arr=new int[2];
    //    for(int i=0;i<nums.length;i++){
    //     for(int j=i+1;j<nums.length;j++){
    //         if(nums[i]+nums[j]==target){
    //             arr[0]=i;
    //             arr[1]=j;
    //             break;
    //         }
    //     }
    //    }
    //    return arr;
    
    HashMap<Integer,Integer> hm=new HashMap<>();
    for(int i=0;i<nums.length;i++){
        int remain=target-nums[i];
        if(hm.containsKey(remain)){
            arr[0]=i;
            arr[1]=hm.get(remain);
            break;
        }
        else{        
            hm.put(nums[i],i);
        }
    }
    return arr;
    }
}