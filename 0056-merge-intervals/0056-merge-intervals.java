class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==1){
            return intervals;
        }

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<int[]> ans=new ArrayList<>();
        int i=0;
        int newInterval[]=new int[2];
        newInterval[0]=intervals[i][0];
        newInterval[1]=intervals[i][1];
        i++;

        while(i<n){
            if(newInterval[1]>=intervals[i][0]){
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            }
            else{
                ans.add(newInterval);
                newInterval=new int[]{intervals[i][0],intervals[i][1]};
            }
            i++;
        }

        ans.add(newInterval);


        int res[][]=new int[ans.size()][2];
        for(int j=0;j<ans.size();j++){
            res[j][0]=ans.get(j)[0];
            res[j][1]=ans.get(j)[1];
        }

        return res;
    }
}