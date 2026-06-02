class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int landfinish=0;
        int waterfinish=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            for(int j=0;j<waterStartTime.length;j++){

                int land=landStartTime[i]+landDuration[i];
                max1=Math.max(land,waterStartTime[j]);
                landfinish=max1+waterDuration[j];


                int water=waterStartTime[j]+waterDuration[j];
                max2=Math.max(landStartTime [i],water);
                waterfinish=max2+landDuration[i];

                ans=Math.min(Math.min(ans,landfinish),waterfinish);
            }
        }
        return ans;
    }
}