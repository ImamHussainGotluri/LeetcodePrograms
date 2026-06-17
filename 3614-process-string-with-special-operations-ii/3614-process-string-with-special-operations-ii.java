class Solution {
    public char processStr(String s, long k) {
        long len=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!='*' && ch!='%' && ch!='#'){
                len++;
            }
            else if(ch=='#'){
                len*=2;
            }
            else if(ch=='*' && len>0){
                    len--;
            }
        }

        if(k<0 || k>=len || len==0){
            return '.';
        }
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='#'){
                len=len/2;
                if(k>=len){
                    k-=len;
                }
            }
            else if(ch=='*'){
                len++;
            }
            else if(ch=='%'){
                k=len-k-1;
            }
            else{
                if(k==len-1){
                    return s.charAt(i);
                }
                len--;
            }
        }
        return '.';
    }
}