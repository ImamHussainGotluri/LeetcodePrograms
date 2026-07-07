class Solution {
    public long sumAndMultiply(int n) {
        String s=String.valueOf(n);
        long sum=0;
        long x=0;
        for(int i=0;i<s.length();i++){
            int val=s.charAt(i)-'0';
            if(val!=0){
                x=x*10+val;
                sum+=val;
            }
        }
        return sum*x;
    }
}