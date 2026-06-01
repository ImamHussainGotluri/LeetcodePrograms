class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum=0;
        int i=cost.length-1;
        int len=0;
        while(i>=0){
            sum+=cost[i];
            len++;
            if(len==2){
                i--;
                len=0;
            }
            i--;
        }
        return sum;
    }
}