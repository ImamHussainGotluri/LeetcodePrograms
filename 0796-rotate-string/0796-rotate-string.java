class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.equals(goal)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            String s1 = s.substring(0, i + 1);
            String s2 = s.substring(i + 1);
            if ((s2 + s1).equals(goal)) {
                return true;
            }
        }
        return false;
    }
}