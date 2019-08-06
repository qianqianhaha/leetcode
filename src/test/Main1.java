package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        //存放结果
        int[] res = new int[n];
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0;i<n;i++){
            nums.add(s.nextInt());
        }


        for(int i=0;i<n;i++){
            //find the min number
            int min = nums.get(0);
//            for(int x:nums){
//                if(x<min)
//                    min = x;
//            }

            //prepare the next list
            ArrayList<Integer> temp = new ArrayList<>(n-1-1);
            for(int j=0;j<nums.size()-1;j++){
                min = Math.min(min,nums.get(j+1));
                temp.add(Math.max(nums.get(j),nums.get(j+1)));
            }
            res[i] = min;
            if(temp.size()>0){
                nums = temp;
            }

        }

        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }

    }
}
