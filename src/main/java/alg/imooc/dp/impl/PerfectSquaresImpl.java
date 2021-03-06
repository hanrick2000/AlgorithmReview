package alg.imooc.dp.impl;

import alg.imooc.dp.PerfectSquares;

public class PerfectSquaresImpl implements PerfectSquares {
    @Override
    public int numSquares(int n) {
        int [] M = new int[n + 1];
        M[0] = 0;
        for(int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, M[i - j*j] + 1);
                j++;
            }
            M[i] = min;
        }
        return M[n];
    }
}
