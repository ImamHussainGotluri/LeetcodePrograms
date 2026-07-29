class Solution {
    public String smallestPalindrome(String s, int k) {
        int n=s.length();

        char ch=' ';
        if(n%2!=0){
            ch=s.charAt(n/2);
        }

        int freq[]=new int[26];

        for(int i=0;i<n;i++){
            if(n%2==1 && i==n/2){
                continue;
            }
            int idx=s.charAt(i)-'a';
            freq[idx]++;
        }

        for(int i=0;i<26;i++){
            freq[i]=freq[i]/2;
        }

        if(getWays(freq,k)<k){
            return "";
        }
        StringBuilder sb1=new StringBuilder();

        for(int i=0;i<n/2;i++){

            for(int j=0;j<26;j++){
                if(freq[j]>0){
                    freq[j]-=1;

                    int ways=getWays(freq,k);

                    if(ways>=k){
                        sb1.append((char)('a'+j));
                        break;
                    }

                    k=k-ways;
                    freq[j]+=1;
                }
            } 
        }

        StringBuilder sb2=new StringBuilder(sb1).reverse();
        StringBuilder ans=new StringBuilder();
        ans.append(sb1);
        if(n%2==1){
            ans.append(ch);
        }
        ans.append(sb2);
        return ans.toString();
    }
    public int getWays(int[] f, long targetK) {
        long ways = 1;
        int currLen = 0;
        for (int count : f) {
            if (count > 0) {
                currLen += count;
                long n = currLen;
                long r = count;
                
                if (r > n - r) r = n - r;
                long curNCr = 1;
                
                for (int i = 1; i <= r; ++i) {
                    curNCr = curNCr * (n - i + 1) / i;
                    if (curNCr > targetK) {
                        curNCr = targetK + 1;
                        break;
                    }
                }
                ways *= curNCr;
                if (ways > targetK) return (int)targetK + 1;
            }
        }
        return (int)ways;
    }
}