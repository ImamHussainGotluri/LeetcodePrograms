class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        pq.addAll(hm.keySet());

        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            char ch=pq.poll();
            int n=hm.get(ch);
            for(int i=0;i<n;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}