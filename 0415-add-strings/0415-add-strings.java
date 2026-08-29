class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0 && j>=0){
            int d1=num1.charAt(i)-'0';
            int d2=num2.charAt(j)-'0';
            
            int sum=d1+d2+carry;
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }
            else{
                carry=0;
            }

            sb.append(sum);
            i--;
            j--;
        }

        while(i>=0){
            int d1=num1.charAt(i)-'0';
            int sum=d1+carry;
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }
            else{
                carry=0;
            }
            i--;
            sb.append(sum);
        }

        while(j>=0){
            int d2=num2.charAt(j)-'0';
            int sum=d2+carry;
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }
            else{
                carry=0;
            }
            j--;
            sb.append(sum);
        }

        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}