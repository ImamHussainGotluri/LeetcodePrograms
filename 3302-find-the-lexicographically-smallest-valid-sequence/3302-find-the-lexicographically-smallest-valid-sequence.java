class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int i = n - 1;
        int j = m - 1;
        int match = 0;
        int right[] = new int[n];
        while (i >= 0) {
            if (j>=0 && word1.charAt(i) == word2.charAt(j)) {
                match++;
                j--;
            } 
            right[i] =match ;
            i--;
        }

        int result[] = new int[m];

        boolean check = true;

        i = 0;
        j = 0;
        int k=0;
        while (i < n && j < m) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(j);

            if (ch1 == ch2) {
                result[k] = i;
                k++;
                j++;
            } else if (check && i+1<n && right[i + 1] >= m - j - 1) {
                result[k] = i;
                k++;
                j++;
                check = false;
            }
            i++;
        }

        if(j==m){
            return result;
        }
        return new int[]{};
    }
}