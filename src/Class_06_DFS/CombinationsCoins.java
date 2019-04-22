package Class_06_DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS EX 3
 * Last review Mar 13 2019
 * Coin value 25 10 5 1
 * print all combination of coins that sum up to a total value k
 * 1. what does it store on each level? (每层代表什么意义， 一般解题前就知道DFS要recur多少层)
 *      4 level (if take 99/n level , it can cause stack over flow!)
 * 2. how many different states should we try to put on this level
 *      depends on input value (25 : 4; 10 : 10 + 8 + 5 + 2 < 99; 5 : ...)
 *
 * T = O (n^4)
 * space = O(4)
 * iteration, it then 一头扎到地　后回溯
 *                         root(99)
 *              /        |         |          \
 *  25        0(99)     1(74)      2(49)      3(24)
 *           /|||||||||\
 *  10     0(99) 1(89)...
 *  5
 *  1
 */
public class CombinationsCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> curSol = new ArrayList<>();
      dfs(res, curSol, coins, target, 0);
      return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> curSol, int[] coins, int remain, int level) {
      // base case
      if(level == coins.length) {
        if(remain == 0) {
          res.add(new ArrayList<>(curSol));
        }
        return;
      }

      int maxCurValue = remain / coins[level];
      for(int i = 0; i <= maxCurValue; i++) {
        curSol.add(i);
        dfs(res, curSol, coins, remain - i * coins[level], level + 1);
        curSol.remove(curSol.size() - 1);
      }
    }

    public static void main(String[] args) {
        CombinationsCoins cc = new CombinationsCoins();
        List<List<Integer>> res = cc.combinations(4, new int[]{2,1});
        System.out.println(res);
    }
}
