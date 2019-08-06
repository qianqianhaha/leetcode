package number;
/**
 * 313 超级丑数
 * 编写一段程序来查找第 n 个超级丑数。
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 */


public class SuperUglyNumber {

    public static void main(String[] args) {
        SuperUglyNumber sun = new SuperUglyNumber();
        int n = 50;
        int[] primes = {2,7,13,19};
        System.out.println(sun.nthSuperUglyNumber(n,primes));

    }

    private int nthSuperUglyNumber(int n, int[] primes) {
        //记录primes数组的每个数下一次应该跟res数组的哪个数相乘
        int[] index = new int[primes.length];
        //记录从1～n步计算每一步满足条件的丑数
        int[] res = new int[n];
        //第一个丑数1
        res[0] = 1;

        int i=1;
        while(i<n){
            int min = Integer.MAX_VALUE;
            //primes数组每一个数和对应的数相乘  并选择最小的那个结果作为下一个丑数
            for(int j=0;j<primes.length;j++){
                int temp = res[index[j]]*primes[j];
                if(temp<min)
                    min = temp;
            }
            res[i++] = min;

            //得到上一步的丑数之后，需要将对应的数下一次相乘的位置向后挪一位
            for(int j=0;j<primes.length;j++){
                if(min==res[index[j]]*primes[j]){
                    index[j]++;
                }
            }
        }
        return res[n-1];

    }



    /*public int nthSuperUglyNumber(int n, int[] primes) {

        //List list = Arrays.asList(primes);
        ArrayList<Integer> list = new ArrayList<>();
        for(int x:primes){
            list.add(x);
        }
        if(n==1)
            return 1;

        List<Integer> primeList = new ArrayList<>();

        //第几个丑数
        int index = 2;
        //丑数
        int res = 2;
        //从2开始
        int num = 2;

        while(index<=n){
            boolean flag = true;
            int i = 2;
            while(i<num){
                if(num%i==0){
                    flag = false;
                    break;
                }
                i++;
            }
            //如果num是质数
            if(flag){
                //将这个数纳入质数列表
                //primeList.add(i);
                //且num在给定的列表中
                if(list.contains(num)){
                    res = num;
                    index++;
                }else{
                    //如果这个数不在list中，则将其加入质数列表
                    primeList.add(num);
                }
                num++;
            }else{
                //这个数是合数
                //遍历目前的质数列表，如果质数列表中有这个合数的因子，则这个合数不满足条件，进入下一次循环
                boolean b = true;
                for(Integer x:primeList){
                    if(num%x==0){
                        b = false;
                        break;
                    }
                }
                if(b){
                    //如果列表中没有这个合数的因子，则满足条件
                    res = num;
                    index++;
                    num++;
                }else{
                    //不满足条件，继续计算
                    num++;
                }

            }

        }


        return res;

    }*/
}
