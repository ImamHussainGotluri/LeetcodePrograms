class Solution {
    public void sortColors(int[] nums) {
        // for(int i=0;i<nums.length;i++){
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[i]<nums[j]){
        //             temp=nums[i];
        //             nums[i]=nums[j];
        //             nums[j]=temp;
        //         }
        //     }   
        // }


        // int c0=0,c1=0,c2=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==0){
        //         c0+=1;
        //     }
        //     else if(nums[i]==1){
        //         c1+=1;
        //     }
        //     else if(nums[i]==2){
        //         c2+=1;
        //     }
        // }
        // for(int i=0;i<c0;i++){
        //     nums[i]=0;
        // }
        // for(int i=c0;i<c0+c1;i++){
        //     nums[i]=1;
        // }
        // for(int i=c1+c0;i<c0+c1+c2;i++){
        //     nums[i]=2;
        // }

           
         int l=0;
         int m=0;
         int r=nums.length-1;
         while(m<=r){
            if(nums[m]==0){
                int temp=nums[l];
                nums[l]=nums[m];
                nums[m]=temp;
                l++;
                m++;
            }
            else if(nums[m]==1){
                m++;
            }
            else if(nums[m]==2){
                int temp=nums[m];
                nums[m]=nums[r];
                nums[r]=temp;
                r--;
            }
         }
    }
}