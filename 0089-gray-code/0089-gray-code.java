class Solution {
    public List<Integer> grayCode(int n) {
        Gray(n, "");
        return res;
    }

    List<Integer> res = new ArrayList<>();

    public void Gray(int n, String ans) {
        if (ans.length() == n) {
            int b = Integer.parseInt(ans, 2);
            int r = b ^ (b >> 1);
            res.add(r);
            return;
        }
        Gray(n, ans + "0");
        Gray(n, ans + "1");
    }
}