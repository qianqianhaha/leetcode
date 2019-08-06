package number;

import java.util.*;

/**
 * 923. 3数和的多种可能性
 * 给定一个整数数组 A，以及一个整数 target 作为目标值，
 * 返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
 *
 * 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
 */
public class SumOf3Num {

    public static void main(String[] args) {
        int[] A = {2,1,3};
        //int[] A = new int[3000];
        int target = 6;
        SumOf3Num sum = new SumOf3Num();
        System.out.println(sum.threeSumMulti(A,target));
    }

    public int threeSumMulti(int[] A, int target) {
        int mod = 1000000007;
        long res = 0;

        //统计数组中每个数字出现的次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:A){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int[] set = new int[map.keySet().size()];
        int i=0;
        for(Integer n:map.keySet()){
            set[i] = n;
            i++;
        }

        Arrays.sort(set);
        for(int j=0;j<set.length;j++){
            int temp1 = set[j];

            for(int k=j;k<set.length;k++){
                int temp2 = set[k];
                int temp3 = target-temp1-temp2;

                if(temp3>=temp2 && map.containsKey(temp3)){
                    if(temp1==temp2 && temp2==temp3 && map.get(temp1)>2){
                        int n = map.get(temp1);
                        long l1 = n*(n-1)/2;
                        long l = l1*(n-2)/3;
                        res = (res+l%mod)%mod;

                    }else if(temp1==temp2 &&temp2!=temp3 && map.get(temp1)>1){
                        int n1 = map.get(temp1);
                        int n2 = map.get(temp3);
                        res = (res+((n1*(n1-1)/2)*n2)%mod)%mod;

                    }else if(temp2==temp3 && temp1!=temp2 && map.get(temp2)>1){
                        int n1 = map.get(temp1);
                        int n2 = map.get(temp2);
                        res = (res+((n1*(n2*(n2-1))/2))%mod)%mod;
                    }else if(temp1==temp3 && temp1!=temp2 && map.get(temp1)>1){
                        int n1 = map.get(temp1);
                        int n2 = map.get(temp2);
                        res = (res+((n1*(n1-1)/2)*n2)%mod)%mod;

                    }else if(temp1!=temp2 && temp2!=temp3 && temp1!=temp3){
                        int n1 = map.get(temp1);
                        int n2 = map.get(temp2);
                        int n3 = map.get(temp3);
                        res = (res+(n1*n2*n3)%mod)%mod;

                    }
                }

            }

        }

        return (int)res%mod;
    }



}
