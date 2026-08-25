class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs=new HashSet<>();
        for(int val:nums){
            hs.add(val);
        }
        for(int i=k;i<Integer.MAX_VALUE;i+=k){
            if(!hs.contains(i)){
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }
}