class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int maxEnd=0;
        for(List<Integer> arr:nums){
            maxEnd=Math.max(maxEnd,arr.get(1));
        }

        int li[]=new int[maxEnd+2];
        for(List<Integer> arr:nums){
            int st=arr.get(0);
            int end=arr.get(1);
            li[st]+=1;
            li[end+1]-=1;
        }

        int cover=0;
        if(li[0]>0){
            cover++;
        }
        for(int i=1;i<li.length;i++){
            li[i]=li[i-1]+li[i];
            if(li[i]>0){
                cover++;
            }
        }
        return cover;
    }
}