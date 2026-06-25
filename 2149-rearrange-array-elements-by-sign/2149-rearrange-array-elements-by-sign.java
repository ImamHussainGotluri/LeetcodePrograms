class Solution {
    public int[] rearrangeArray(int[] nums) {
    //     int l=0;
    //     int m=0;
    //     int ptemp[]=new int[nums.length/2];
    //     int ntemp[]=new int[nums.length/2];
    //     int merge[]=new int[nums.length];
    //    for(int i=0;i<nums.length;i++){
    //     if(nums[i]>0){
    //         ptemp[l]=nums[i];
    //         l++;
    //     }
    //     else if(nums[i]<0){
    //         ntemp[m]=nums[i];
    //         m++;
    //     }
    //    }
    //    int i=0,j=0;
    //    int k=0;
    //   while(i<ptemp.length && j<ntemp.length){
    //     merge[k++]=ptemp[i++];
    //     merge[k++]=ntemp[j++];
    //   }

    //   ArrayList<Integer> parr=new ArrayList<>();
    //   ArrayList<Integer> narr=new ArrayList<>();
    //   for(int i=0;i<nums.length;i++){
    //     if(nums[i]>0){
    //         parr.add(nums[i]);
    //     }
    //     else{
    //         narr.add(nums[i]);
    //     }
    //   }
      
    //  for(int i=0;i<nums.length/2;i++){
    //     nums[2*i]=parr.get(i);
    //     nums[2*i+1]=narr.get(i);
    //   }
    //    return nums;

        int n=nums.length;
        int arr[]=new int[n];
        int pos=0;
        int neg=1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                arr[pos]=nums[i];
                pos+=2;
            }
            else{
                arr[neg]=nums[i];
                neg+=2;
            }
        }
        return arr;
    }
}