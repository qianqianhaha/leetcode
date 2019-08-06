package number;

import java.util.*;

/**
 * 根据函数日志计算函数的独占时间
 * 日志格式：0:start:0 函数0 起始执行时刻为0   0:end:0 函数0 终止执行时刻为0  --》函数0 的执行时间为1
 */
public class ExeTimeOfFunc {

    public static void main(String[] args) {
        int n = 3;
        List<String>logs = Arrays.asList("0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3");
        ExeTimeOfFunc etof = new ExeTimeOfFunc();
        int[] res = etof.exclusiveTime(n,logs);

        for(int i=0;i<n;i++){
            System.out.print(res[i]+"  ");
        }

    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();

        if(logs==null || logs.size()<=1)
            return null;

        Stack<Integer> stack = new Stack<>();

        String[] temp1 = logs.get(0).split(":");
        String[] temp2;

        stack.push(Integer.parseInt(temp1[0]));

        for(int i=1;i<logs.size();i++){
            int top = 0;
            temp2 = logs.get(i).split(":");
            if(!stack.isEmpty()){
                top = stack.peek();
            }else{
                top = Integer.parseInt(temp2[0]);
            }
            if(temp2[1].equals("start")){
                stack.push(Integer.parseInt(temp2[0]));
            }else{
                stack.pop();
            }

            int temp = 0;
            if(temp1[1].equals("start") && temp2[1].equals("end")){
                temp = Integer.parseInt(temp2[2])-Integer.parseInt(temp1[2])+1;

            }else if(temp1[1].equals("end") && temp2[1].equals("start")){
                temp = Integer.parseInt(temp2[2])-Integer.parseInt(temp1[2])-1;
            }else{
                temp = Integer.parseInt(temp2[2])-Integer.parseInt(temp1[2]);
            }
            map.put(top,map.getOrDefault(top,0)+temp);

            temp1 = temp2;

        }

        for(Map.Entry entry:map.entrySet()){
            res[(int)entry.getKey()] = (int)entry.getValue();
        }

        return res;
    }
}
