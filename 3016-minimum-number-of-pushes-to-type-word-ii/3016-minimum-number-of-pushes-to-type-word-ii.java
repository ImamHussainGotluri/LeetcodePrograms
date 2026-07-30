class Solution {
    public int minimumPushes(String word) {
        int freq[]=new int[26];
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            freq[idx]++;
        }

        List<Integer> arr=new ArrayList<>(); 
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                arr.add(freq[i]);
            }
        }

        Collections.sort(arr);

        int cnt=0;
        int btn=1;
        int ans=0;
        for(int i=arr.size()-1;i>=0;i--){
            int f=arr.get(i);

            ans+=f*btn;

            cnt++;

            if(cnt==8){
                cnt=0;
                btn++;
            }
        }
        return ans;
    }
}