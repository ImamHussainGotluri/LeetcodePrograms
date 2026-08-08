class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int right[] = new int[m];
        int i = n - 1;
        int j = m - 1;
        int match = 0;

        while (j >= 0) {

            if (i >= 0 && s.charAt(i) == t.charAt(j)) {
                match++;
                i--;
            }
            right[j] = match;
            j--;

        }

        boolean check = true;
        i = 0;
        j = 0;
        while (i < n && j < m) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(j);

            if (ch1 == ch2) {
                i++;
            } else if (check && (n - i - 1 == 0 || j + 1 < m && right[j + 1] >= n - i - 1)) {
                i++;
                check = false;
            }
            j++;

        }

        if (i == n) {
            return true;
        }
        return false;
    }
}