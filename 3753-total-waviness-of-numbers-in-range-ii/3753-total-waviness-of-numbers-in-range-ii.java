class Solution {
    char[] digits;

    long[][][][][] waysDP;
    long[][][][][] waveDP;

    public long totalWaviness(long num1, long num2) {
        return count(num2) - count(num1 - 1);
    }

    public long count(long num) {
        if (num < 0) return 0;

        digits = String.valueOf(num).toCharArray();

        waysDP = new long[20][2][11][11][2];
        waveDP = new long[20][2][11][11][2];

        fillDP(waysDP);
        fillDP(waveDP);

        return solve(0, 1, -1, -1, 0)[1];
    }

    public void fillDP(long[][][][][] dp) {
        for (long[][][][] a : dp)
            for (long[][][] b : a)
                for (long[][] c : b)
                    for (long[] d : c)
                        Arrays.fill(d, -1);
    }

    // returns {ways, waves}
    public long[] solve(int pos, int tight, int prevDigit, int secPrevDigit, int started) {
        if (pos == digits.length) {
            return new long[]{1, 0};
        }

        int prevIdx = prevDigit + 1;
        int secPrevIdx = secPrevDigit + 1;

        if (waysDP[pos][tight][prevIdx][secPrevIdx][started] != -1) {
            return new long[]{
                waysDP[pos][tight][prevIdx][secPrevIdx][started],
                waveDP[pos][tight][prevIdx][secPrevIdx][started]
            };
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;

        long totalWays = 0;
        long totalWaves = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {
                long[] next = solve(pos + 1, newTight, -1, -1, 0);

                totalWays += next[0];
                totalWaves += next[1];
            } 
            else {
                int isWave = 0;

                if (secPrevDigit != -1 && prevDigit != -1) {
                    if ((secPrevDigit < prevDigit && prevDigit > d) ||
                        (secPrevDigit > prevDigit && prevDigit < d)) {
                        isWave = 1;
                    }
                }

                long[] next = solve(pos + 1, newTight, d, prevDigit, 1);

                totalWays += next[0];
                totalWaves += next[1] + isWave * next[0];
            }
        }

        waysDP[pos][tight][prevIdx][secPrevIdx][started] = totalWays;
        waveDP[pos][tight][prevIdx][secPrevIdx][started] = totalWaves;

        return new long[]{totalWays, totalWaves};
    }
}