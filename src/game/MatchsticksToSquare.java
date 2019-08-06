package game;
/**
 * 473  回溯算法
 * 找出一种能使用所有火柴拼成一个正方形的方法。
 * 不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 */

import java.util.Arrays;

public class MatchsticksToSquare {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //int[] nums = {3,3,3,3,4};
        MatchsticksToSquare mt = new MatchsticksToSquare();
        System.out.println(mt.makesquare(nums));
    }

    private boolean res = false;

    public boolean makesquare(int[] nums) {

        if(nums.length<=0)
            return false;
        //遍历数组 求和
        int sum = 0;
        for(int i:nums)
            sum += i;
        //如果sum不能被4整除，则返回false
        if(sum%4!=0)
            return false;
        //要求经过组合，每条边最终的长度都必须为target
        int target = sum/4;
        //遍历数组，如果存在>target的元素，返回false
        for(int i:nums){
            if(i>target)
                return false;
        }
        //进入回溯算法
        Arrays.sort(nums);
        backtracks(nums.length-1,target,nums,new int[4]);

        return res;
    }

    private void backtracks(int i, int target, int[] nums, int[] ints) {
        if(res)
            return;

        //如果数组遍历完毕
        if(i==-1){
            for(int n:ints){
                if(n!=target)
                    return;
            }
            res = true;
            return;
        }

        //数组还没有遍历完毕
        //对每个数，都需要尝试四个位置
        for(int j=0;j<ints.length;j++){
            int temp = ints[j];
            ints[j] += nums[i];
            //只有在满足不超过target的条件时 才进入下一步
            if(ints[j]<target){
                backtracks(i-1,target,nums,ints);
            }
            //如果正确放置，则会正确返回，不会到达这一步
            //到达这一步则代表需要回溯
            ints[j] = temp;
        }

    }


}
