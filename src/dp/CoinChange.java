package dp;

/**
 * 动态规划解决找零问题
 * 求所有的找零方案的总方案数: array[amount]
 * 以及所有找零方案的总硬币数: nums[amount]
 */
public class CoinChange {
    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {1,2};
        int amount = 10;
        System.out.println(cc.change(amount,coins));
    }

    public int change(int amount, int[] coins) {
        //记录方案数
        int[] array = new int[amount+1];
        //记录总硬币数
        int[] nums = new int[amount+1];
        array[0] = 1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                array[i] = array[i]+array[i-coin];
                nums[i] = nums[i]+nums[i-coin]+array[i-coin];
            }
        }
        return nums[amount];
    }
}
