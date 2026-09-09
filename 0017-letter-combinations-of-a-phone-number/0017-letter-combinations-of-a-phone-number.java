class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> str = new ArrayList<>();
        if (digits.length() == 0) {
            return str;
        }
        return keyCombination(digits);
    }

    static String codes[] = { ":'", "?", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> keyCombination(String digits) {
        if(digits.length()==0){
            List<String> newRes=new ArrayList<>();
            newRes.add("");
            return newRes;
        }

        char ch=digits.charAt(0);
        String s=digits.substring(1);
        List<String> newList=keyCombination(s);
        List<String> res=new ArrayList<>();
        String newStr=codes[ch-'0'];
        for(int i=0;i<newStr.length();i++){
            char newCh=newStr.charAt(i);
            for(String innerStr:newList){
                res.add(newCh+innerStr);
            }
        }
        return res;
    }
}