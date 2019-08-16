package test;
/**
 * 360笔试 第一题 求多个正方体堆砌出立体图形的表面积
 */

import java.util.Scanner;

public class Main6 {

    /*public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //n行
        int n = s.nextInt();
        //m列
        int m= s.nextInt();
        int S = 0;

        //接收二维矩阵输入
        int[][] nums = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nums[i][j] = s.nextInt();
            }
        }

        int temp = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(nums[i][j]==0)
                    continue;

                temp++;
                //a[i][j]处至少有一个正方体
                for(int k=1;k<=nums[i][j];k++){

//                    //检查下方
//                    if(k==1)
//                        S+=1;
                    //检查前后
                    if(i==0 && i==n-1)
                        S +=2;
                    else if(i==0 && i!=n-1){
                        S +=1;
                        if(nums[i+1][j]<k)
                            S +=1;
                    }else if(i!=0 && i==n-1){
                        S +=1;
                        if(nums[i-1][j]<k)
                            S += 1;
                    }else if(i!=0 && i!=n-1){
                        if(nums[i+1][j]<k)
                            S +=1;
                        if(nums[i-1][j]<k)
                            S +=1;

                    }

                    //检查左右
                    if(j==0 &&j==m-1){
                        S+=2;
                    }else if(j==0 && j!=m-1){
                        S+=1;
                        if(nums[i][j+1]<k)
                            S+=1;
                    }else if(j!=0 && j==m-1){
                        S+=1;
                        if(nums[i][j-1]<k)
                            S+=1;
                    }else if(j!=0 && j!=m-1){
                        if(nums[i][j+1]<k)
                            S+=1;
                        if(nums[i][j-1]<k)
                            S+=1;
                    }

//                    //检查上方
//                    if(nums[i][j]==k)
//                        S+=1;
                }

            }
        }
        S += temp*2;
        System.out.print(S);

    }*/

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //n行
        int n = s.nextInt();
        //m列
        int m= s.nextInt();
        int S = 0;

        //接收二维矩阵输入
        int[][] nums = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nums[i][j] = s.nextInt();
            }
        }
        int updown = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int height = nums[i][j];
                if(height==0)
                    continue;
                updown++;
                //得到前后左右四个立方柱的高度
                int height1 = i-1>=0?nums[i-1][j]:0;
                int height2 = i+1<n?nums[i+1][j]:0;
                int height3 = j-1>=0?nums[i][j-1]:0;
                int height4 = j+1<m?nums[i][j+1]:0;

                S +=(height-height1)>0?height-height1:0;
                S +=(height-height2)>0?height-height2:0;
                S +=(height-height3)>0?height-height3:0;
                S +=(height-height4)>0?height-height4:0;

            }
        }

        S += updown*2;
        System.out.print(S);
    }
}
