class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Map<String,Integer> hm=new HashMap<>();
        for(int i=0;i<arr2.length;i++){
            String s=Integer.toString(arr2[i]);
            String prefix="";
            for(char ch:s.toCharArray()){
                prefix+=ch;
                if(!hm.containsKey(prefix)){
                    hm.put(prefix,prefix.length());
                }
            }
        }
        int res=0;
        for(int i=0;i<arr1.length;i++){
            String temp=Integer.toString(arr1[i]);
            String newstr="";
            for(char ch:temp.toCharArray()){
                newstr+=ch;
                if(hm.containsKey(newstr)){
                    res=Math.max(hm.get(newstr),res);
                }
            }
        }
        return res;
    }
}