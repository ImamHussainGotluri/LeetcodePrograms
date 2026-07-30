class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int btn=1;
        int ans=0;
        Map<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){

            char ch=word.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch,btn);
                ans+=btn;
            }
            else{
                ans+=hm.get(ch);
            }

            if((i+1)%8==0){
                btn++;
            }

        }
        return ans;
    }
}