class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> str = new ArrayList<>();
        if (digits.length() == 0) {
            return str;
        }
        // return keyCombination(digits);
        return helper(0,digits,new StringBuilder(),new ArrayList<>());
    }

    static String codes[] = { ":'", "?", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    // public static List<String> keyCombination(String digits) {
    //     if(digits.length()==0){
    //         List<String> newRes=new ArrayList<>();
    //         newRes.add("");
    //         return newRes;
    //     }

    //     char ch=digits.charAt(0);
    //     String s=digits.substring(1);
    //     List<String> newList=keyCombination(s);
    //     List<String> res=new ArrayList<>();
    //     String newStr=codes[ch-'0'];
    //     for(int i=0;i<newStr.length();i++){
    //         char newCh=newStr.charAt(i);
    //         for(String innerStr:newList){
    //             res.add(newCh+innerStr);
    //         }
    //     }
    //     return res;
    // }
    public List<String> helper(int idx,String digits,StringBuilder sb,List<String> ans){
        if(idx==digits.length()){
            ans.add(sb.toString());
            return ans;
        }

        int i=digits.charAt(idx)-'0';
        String s=codes[i];
        for(char ch:s.toCharArray()){
            sb.append(ch);
            helper(idx+1,digits,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
        return ans;
    }
}