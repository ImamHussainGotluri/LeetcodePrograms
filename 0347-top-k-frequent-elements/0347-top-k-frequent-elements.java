class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int res[]=new int[k];
        Map<Integer,Integer> hm=new HashMap<>();
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int val:hm.values()){
            pq.add(val);
        }

        int i=0;
        while(k>0 && !pq.isEmpty()){
            int freq=pq.poll();
            for(int key:hm.keySet()){
                if(hm.get(key)==freq){
                    res[i++]=key;
                    hm.remove(key);
                    k--;
                    break;
                }
            }
        }
        return res; 

        // HashMap<Integer,Integer> hm=new HashMap<>();
        // for(int num:nums){
        // hm.put(num,hm.getOrDefault(num,0)+1);
        // } 
        // PriorityQueue<HashMap.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        // pq.addAll(hm.entrySet());

        // for(int i=0;i<k;i++){
        // ans[i]=pq.poll().getKey();
        // }
        // return ans;
    }
}