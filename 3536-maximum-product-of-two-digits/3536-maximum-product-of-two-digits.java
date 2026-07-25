class Solution {
    public int maxProduct(int n) {
        if (n <= 1) {
            return n;
        }
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        while (n != 0) {

            int val = n % 10;
            if (val >= firstMax) {
                secondMax = firstMax;
                firstMax = val;
            } else if (val > secondMax && val != firstMax ) {
                secondMax = val;
            }

            n = n / 10;
        }
        return firstMax * secondMax;
    }
}