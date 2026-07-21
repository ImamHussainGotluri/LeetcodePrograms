class Solution {
    public int maxPower(String s) {
        int cnt=1;
        int ans=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)==s.charAt(i)){
                cnt++;
                ans=Math.max(ans,cnt);
            }
            else{
                cnt=1;
            }
        }
        return ans;
    }
}