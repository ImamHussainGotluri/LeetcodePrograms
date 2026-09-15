class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n=word.length();
        int res[]=new int[n];

        long sum=0;
        for(int i=0;i<n;i++){
            int digit=word.charAt(i)-'0';
            sum=(sum*10+digit)%m;

            if(sum==0){
                res[i]=1;
            }
            else{
                res[i]=0;
            }
        }

        return res;
    }
}