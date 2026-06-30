class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int lastA = -1, lastB = -1, lastC = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                lastA=i;
            } else if (ch == 'b') {
                lastB=i;;
            } else {
                lastC=i;
            }

            if (lastA != -1 && lastB != -1 && lastC != -1) {
                int valid= Math.min(lastA,Math.min(lastB,lastC));
                ans+=valid+1;
            }
        }
        return ans;
    }
}