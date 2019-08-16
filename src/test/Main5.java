package test;
/**
 * 360笔试 第二题  两组长度为n的m进制的数字串，要求将其按位相加对m取余 求得到的最大的数
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //n位
        int n = s.nextInt();
        //m进制
        int m= s.nextInt();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=0;i<n;i++){
            list1.add(s.nextInt());
        }
        for(int i=0;i<n;i++){
            list2.add(s.nextInt());
        }

        while(!list2.isEmpty()){
            ArrayList<Integer> list3 = new ArrayList<>();
            for(int i=0;i<n;i++){
                int temp = m-list1.get(i);
                list3.add(temp);
            }

            List<Integer> list4 = new ArrayList<>(list2);
            System.out.print(list4.retainAll(list3));
            for(int i=0;i<list4.size();i++){
                System.out.print(m-1+" ");
            }
            list2.removeAll(list4);

            m--;
        }



//        while(!list1.isEmpty()){
//            int size = list1.size();
//            int max = Integer.MIN_VALUE;
//            int index1 = 0;
//            int index2 = 0;
//            boolean b = false;
//            for(int i=0;i<size;i++){
//                if(b){
//                    b = false;
//                    break;
//                }
//                int n1 = list1.get(i);
//                for(int j=0;j<size;j++){
//                    int n2 = list2.get(j);
//                    if((n1+n2)%m==m-1){
//                        index1 = i;
//                        index2 = j;
//                        max = (n1+n2)%m;
//                        b = true;
//                        break;
//                    }
//                    if((n1+n2)%m>max){
//                        max = (n1+n2)%m;
//                        index1 = i;
//                        index2 = j;
//                    }
//
//                }
//            }
//            System.out.print(max+" ");
//            list1.remove(index1+0);
//            list2.remove(index2+0);
//
//        }

    }
}
