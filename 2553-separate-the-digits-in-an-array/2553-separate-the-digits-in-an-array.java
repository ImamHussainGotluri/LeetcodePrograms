class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        for(int num:nums){
            String s=String.valueOf(num);
            for(int i=0;i<s.length();i++){
                arr.add(s.charAt(i)-'0');
            }
        }

        int res[]=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            res[i]=arr.get(i);
        }
        return res;
    }
}