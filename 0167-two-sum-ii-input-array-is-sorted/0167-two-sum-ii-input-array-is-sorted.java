class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int arr[]=new int[2];
        // for(int i=0;i<numbers.length;i++){
        //     for(int j=i+1;j<numbers.length;j++){
        //         if(numbers[i]+numbers[j]==target){
        //             arr[0]=i+1;
        //             arr[1]=j+1;
        //             break;
        //         }
        //     }
        // }
     int left=0,right=numbers.length-1;
     int sum=0;
        while(left<=right){
            sum=numbers[left]+numbers[right];
            if(sum==target){
                arr[0]=left+1;
                arr[1]=right+1;
                break;
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return arr;
    }
}