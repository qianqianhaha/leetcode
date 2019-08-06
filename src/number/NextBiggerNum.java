package number;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 503. 给定循环数组，输出每个元素的下一个更大元素
 */
public class NextBiggerNum {

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        NextBiggerNum nbn = new NextBiggerNum();
        int[] res = nbn.nextGreaterElements(nums);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        //使用栈结构，从右往左遍历
        for(int i=2*nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%nums.length])
                stack.pop();
            res[i%nums.length] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%nums.length]);

        }

        return res;

    }
    /*public int[] nextGreaterElements(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] res = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            res[i] = -1;
        }

        for(int i=0;i<=2*(nums.length-1);i++){
            if(i>0 && i<nums.length && i==list.size() && nums[i]<=nums[i-1]){
                list.add(i);
                continue;
            }

            ArrayList<Integer> temp = new ArrayList<>();
            for(int index:list){
                if(nums[i%nums.length]>nums[index]){
                    res[index] = nums[i%nums.length];
                    temp.add(index);
                }

            }
            list.removeAll(temp);
            if(list.size()==1 && list.contains(i%nums.length))
                break;

            if(i<nums.length){
                list.add(i);
            }

        }


        return res;
    }*/
}
