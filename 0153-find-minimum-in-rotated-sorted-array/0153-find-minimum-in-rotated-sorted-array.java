class Solution {
    public int findMin(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!arr.contains(nums[i])){
                arr.add(nums[i]);
            }
        }
        int l=0;
        int r=arr.size()-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr.get(mid)>arr.get(r)){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return arr.get(l);
    }
}