class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int diff[]=new int[n];
        for(int book[]:bookings){
            int l=book[0];
            int r=book[1];
            int seats=book[2];
            diff[l-1]+=seats;
            if(r<n){
                diff[r]-=seats;
            }
        }
        int prefix[]=new int[n];
        prefix[0]=diff[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+diff[i];
        }
        return prefix;
    }
}