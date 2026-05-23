class Solution {
    public boolean check(int[] nums) {
       int arr[]=new int[nums.length];
    for(int i=0;i<nums.length;i++){
        arr[i]=nums[i];
    }
    Arrays.sort(arr);
    int k=0;
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]>nums[i+1]){
            k=i+1;
        }
    }
    for(int i=0;i<nums.length-1;i++){
        if(arr[i]!=nums[(i+k)%nums.length]){
            return false;
        }
    }
    return true;
    }
}