class Solution {
    public int totalWaviness(int num1, int num2) {
        int cnt=0;
        for(int i=num1;i<=num2;i++){
            String s=String.valueOf(i);
            if(s.length()<3){
                continue;
            }
            for(int j=1;j<s.length()-1;j++){
                int prev=s.charAt(j-1)-'0';
                int curr=s.charAt(j)-'0';
                int next=s.charAt(j+1)-'0';
                if(prev<curr && next<curr){
                    cnt+=1;
                    continue;
                }

                if(prev>curr && next>curr){
                    cnt+=1;
                }
            }
        }
        return cnt;
    }
}