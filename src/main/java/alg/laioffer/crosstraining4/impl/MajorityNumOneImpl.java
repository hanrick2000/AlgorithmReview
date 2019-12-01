package alg.laioffer.crosstraining4.impl;

import alg.laioffer.crosstraining4.MajorityNumOne;

public class MajorityNumOneImpl implements MajorityNumOne {
    static class Majority {
        int val, count;
        public Majority(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    @Override
    public int majority(int[] array) {
        Majority res = new Majority(array[0], 1);
        for(int curVal : array) {
            if(curVal == res.val) {
                res.count++;
            } else {
                if(res.count == 0) {
                    res.val = curVal;
                } else {
                    res.count--;
                }
            }
        }
        return res.val;
    }
}
