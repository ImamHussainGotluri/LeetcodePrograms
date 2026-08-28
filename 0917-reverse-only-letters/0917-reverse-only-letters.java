class Solution {
    public String reverseOnlyLetters(String s) {
        int l=0;
        int r=s.length()-1;

        char arr[]=s.toCharArray();
        while(l<r){
            char ch1=arr[l];
            char ch2=arr[r];

            if(!Character.isLetter(ch1)){
                l++;
                continue;
            }

            if(!Character.isLetter(ch2)){
                r--;
                continue;
            }

            char ch=arr[l];
            arr[l]=arr[r];
            arr[r]=ch;
            l++;
            r--;
        }
        String ans=String.valueOf(arr);
        return ans;
    }
}