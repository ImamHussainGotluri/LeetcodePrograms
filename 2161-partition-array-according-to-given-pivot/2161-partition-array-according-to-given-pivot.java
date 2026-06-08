class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less=new ArrayList<>();
        List<Integer> equal=new ArrayList<>();
        List<Integer> great=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                less.add(nums[i]);
            }
            else if(nums[i]>pivot){
                great.add(nums[i]);
            }
            else{
                equal.add(nums[i]);
            }
        }

        int j=0;
        for(int i=0;i<less.size();i++){
            nums[j++]=less.get(i);
        }
        for(int i=0;i<equal.size();i++){
            nums[j++]=equal.get(i);
        }
        for(int i=0;i<great.size();i++){
            nums[j++]=great.get(i);
        }

        return nums;

    }
}