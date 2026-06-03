class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minLand=solve(landStartTime,landDuration,waterStartTime,waterDuration);
        int minWater=solve(waterStartTime,waterDuration,landStartTime,landDuration);
        return Math.min(minLand,minWater);
    }
    public int solve(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration){
        int minLand=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            minLand=Math.min(minLand,landStartTime[i]+landDuration[i]);
        }

        int minWater=Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            int maxWater=Math.max(minLand,waterStartTime[i]);

            minWater=Math.min(minWater,maxWater+waterDuration[i]);
        }
        return minWater;
    }
}