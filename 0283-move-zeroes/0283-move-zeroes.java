class Solution {
    public void moveZeroes(int[] nums) {
        // int temp[]=new int[nums.length];
        // int l=0;
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //   if(nums[i]!=0){
        //     temp[l++]=nums[i];
        //   }
        //   else{
        //     count++;
        //   }
        // }
        // while(count>0){
        //     temp[l++]=0;
        //     count--;
        // }
        // for(int i=0;i<nums.length;i++){
        //     nums[i]=temp[i];
        // }

        int l=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]!=0){
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
            }
            if(nums[l]!=0){
                l++;
            }
        }
    }
}