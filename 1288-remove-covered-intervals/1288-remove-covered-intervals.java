class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;

        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return b[1]-a[1];
        });
        
        int check[]=new int[2];
        check[0]=intervals[0][0];
        check[1]=intervals[0][1];
        int cover=0;
        int maxEnd=intervals[0][1];
        for(int i=1;i<n;i++){
            if(maxEnd>=intervals[i][1]){ 
                cover++;
            }
            else{
                maxEnd=intervals[i][1];
            }
        }
        System.out.println(n);
        return n-cover;
    }
}