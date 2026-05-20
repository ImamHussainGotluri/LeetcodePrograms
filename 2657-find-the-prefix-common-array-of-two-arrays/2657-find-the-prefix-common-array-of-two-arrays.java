class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int res[]=new int[n];
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int cnt=i==0?0:res[i-1];
            if(A[i]==B[i]){
                cnt++;
            }
            if(hm.containsKey(A[i])){
                cnt+=hm.get(A[i]);
            }
            if(hm.containsKey(B[i])){
                cnt+=hm.get(B[i]);
            }
            hm.put(A[i],hm.getOrDefault(A[i],0)+1);
            hm.put(B[i],hm.getOrDefault(B[i],0)+1);
            res[i]=cnt;
        }
        return res;
    }
}