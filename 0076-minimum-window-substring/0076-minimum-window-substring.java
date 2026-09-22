class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int l=0;
        int st=0;
        int end=0;
        int ans=Integer.MAX_VALUE;
        
        int freq1[]=new int[256];
        int freq2[]=new int[256];
        
        for(int i=0;i<t.length();i++){
            freq1[t.charAt(i)]++;
        }
        
        
        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            freq2[ch]++;
            
            while(helper1(freq1,freq2,t)){
                
                if(r-l+1<ans){
                    ans=r-l+1;
                    st=l;
                    end=r;
                }
                
                char pch=s.charAt(l);
                freq2[pch]--;
                l++;
            }
            
        }
        
        if(ans==Integer.MAX_VALUE){
            return "";
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=st;i<=end;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
        
    }
    public static boolean helper1(int freq1[],int freq2[],String p){
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            
            if(freq2[ch]<freq1[ch]){
                return false;
            }
        }
        return true;
    }
}