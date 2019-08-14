package compute;
/**
 * 241 为运算表达式设计优先级
 *
 * 使用分治法  不断的将字符串按运算符分成左右两端，进行递归运算，
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 */

import java.util.ArrayList;
import java.util.List;

public class ExpressCompute {

    public static void main(String[] args) {
        String input = "2*3-4*5";
        ExpressCompute ec = new ExpressCompute();
        List<Integer> list = ec.diffWaysToCompute(input);
        for(int i:list){
            System.out.print(i+" ");
        }
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(!(input.contains("+") || input.contains("-") || input.contains("*"))){
            res.add(Integer.parseInt(input));
        }

        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='*'){
                for(Integer i1:diffWaysToCompute(input.substring(0,i))){
                    for(Integer i2:diffWaysToCompute(input.substring(i+1))){
                        if(input.charAt(i)=='+'){
                            res.add(i1+i2);
                        }else if(input.charAt(i)=='-'){
                            res.add(i1-i2);
                        }else{
                            res.add(i1*i2);
                        }

                    }

                }

            }

        }

       return res;
    }

}
