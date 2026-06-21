class Solution {
    public int maximumPopulation(int[][] logs) {
        int n=2050;

        int diff[]=new int[2050+2];
        for(int log[]:logs){
            int b=log[0];
            int d=log[1];

            diff[b]+=1;
            diff[d]-=1;
        }

        int max=0;
        int year=0;
        for(int i=1950;i<n+2;i++){
            diff[i]=diff[i-1]+diff[i];
            if(diff[i]>max){
                max=diff[i];
                year=i;
            }
        }
        return year;
    }
}