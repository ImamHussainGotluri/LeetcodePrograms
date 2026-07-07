class Solution {
    public long sumAndMultiply(int n) {
        // String s=String.valueOf(n);
        // long sum=0;
        // long x=0;
        // for(int i=0;i<s.length();i++){
        //     int val=s.charAt(i)-'0';
        //     if(val!=0){
        //         x=x*10+val;
        //         sum+=val;
        //     }
        // }
        // return sum*x;

        long num=0;
        long sum=0;
        while(n!=0){
            int digit=n%10;
            if(digit!=0){
                num=num*10+digit;
                sum+=digit;
            }
            n=n/10;
        }

        long ans=0;
        while(num!=0){

            ans=ans*10+num%10;
            num=num/10;
        }
        return ans*sum;
    }
}