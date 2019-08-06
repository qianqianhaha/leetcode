package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //n个数字
        int n = s.nextInt();
        //q个操作
        int q= s.nextInt();

        //用list存放这些数据
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(s.nextInt());
        }
        //对nums进行升序排序
        Collections.sort(nums);


        for(int i=0;i<q;i++){
            int cope = s.nextInt();
            if(cope<=nums.get(nums.size()-1)){
                //二分查找cope
                int index = 0;
                if(nums.indexOf(cope)!=-1){
                    index = nums.indexOf(cope);
                }else{
                    index = binarySearch(cope,nums);
                }
                for(int j=index;j<nums.size();j++){
                    nums.set(j,nums.get(j)-1);
                }
                System.out.println(nums.size()-index);
            }else{
                System.out.println(0);
            }
        }

    }

    private static int binarySearch(int cope, ArrayList<Integer> nums) {
        int n = nums.size();
        int left = 0;
        int right = n;
        while(left<right){
            int mid = (left+right)/2;
            if(nums.get(mid)<cope)
                left = mid+1;
            else if(nums.get(mid)>cope)
                right = mid;
            else if(nums.get(mid)==cope)
                return mid;
        }
        return left;

    }
}
