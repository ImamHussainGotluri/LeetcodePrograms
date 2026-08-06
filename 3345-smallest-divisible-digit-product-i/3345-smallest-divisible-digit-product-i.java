class Solution {
    public int smallestNumber(int n, int t) {
        int currnum=n;

        int prod=1;
        while(n>0){
            int d=n%10;
            prod=prod*d;
            n/=10;
        }
        if(prod%t==0){
            return currnum;
        }
        return smallestNumber(currnum+1,t);
    }

}