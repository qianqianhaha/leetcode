package number;

import java.util.Stack;

/**
 * 1124 给定工作时长，>8表示状态好 <=8反之
 * 求最长表现良好时间段
 */
public class NicePerformPeriod {

    //利用前缀和 单调递减栈

    public int longestWPI(int[] hours){
        int res = 0;
        int[] preSum = new int[hours.length+1];
        int sum = 0;
        //求前缀和数组
        for(int i=0;i<hours.length;i++){
            if(hours[i]>8){
               sum+=1;
            }else{
                sum+=-1;
            }
            preSum[i+1] = sum;

        }

        //构建单调递减栈
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<preSum.length;i++){
            if(stack.isEmpty() || preSum[i]<preSum[stack.peek()]){
                stack.push(i);
            }
        }

        //从后向前遍历
        for(int i=preSum.length-1;i>=0;i--){

            while(!stack.isEmpty() && preSum[i]>preSum[stack.peek()]){
                res = Math.max(res,i-stack.peek());
                stack.pop();
            }

        }
        return res;
    }
}
