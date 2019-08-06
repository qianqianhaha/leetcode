package number;

import java.util.ArrayList;

public class NumberOfOne {
    public static void main(String[] args) {
        NumberOfOne noo = new NumberOfOne();
        System.out.println(noo.countDigitOne(13));
    }

    public int countDigitOne(int n) {
        int res = 0;
        if(n<=0)
            return res;
        int copy = n;
        //按位存储每一个数
        ArrayList<Integer> list = new ArrayList<>();
        while(copy>0){
            list.add(copy%10);
            copy = copy/10;
        }

        int len = list.size();
        boolean flag = false;
        int index = 0;

        for(int i=0;i<len;i++){
            if(flag){
                int temp = (int) Math.pow(10,len-index);
                res = res+(n%temp)+1;
                break;
            }
            int bit = 0;
            while(bit<list.get(len-1-i)){
                if(bit==1){
                    res = res+10^(len-1-i);
                }else{
                    int temp = (int) ((int) Math.pow(10,len-1-i)-Math.pow(9,len-1-i));
                    res = res+temp;
                }
                bit++;
            }

            if(bit==1){
                flag = true;
                index = i+1;
            }

        }
        return res;

    }
}
