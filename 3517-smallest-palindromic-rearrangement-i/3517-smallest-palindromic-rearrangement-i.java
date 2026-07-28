class Solution {
    public String smallestPalindrome(String s) {
        int freq[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            freq[idx]++;
        }

        StringBuilder sb1 = new StringBuilder();

        char mid = 'a';

        for (int i = 0; i < 26; i++) {
            int cnt = freq[i];
            char ch = (char) ('a' + i);

            for (int j = 0; j < freq[i] / 2; j++) {
                sb1.append(ch);
            }

            if (freq[i] % 2 == 1) {
                mid = ch;
            }

        }


        StringBuilder sb2 = new StringBuilder(sb1).reverse();

         if (s.length() % 2 != 0) {
            sb1.append(mid);
        }
        return sb1.toString() + sb2.toString();
    }
}