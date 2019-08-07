package matrix;

public class BoundedSubarrays {
    public static void main(String[] args) {
        int[] A= {2,1,4,3};
        BoundedSubarrays bs = new BoundedSubarrays();
        System.out.println(bs.numSubarrayBoundedMax(A,2,3));
    }
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        //方法一 滑动窗口  一个for循环
        /*int res = 0;
        if(A==null || A.length<=0)  return 0;

        int left = 0;
        int right = 0;
        while(right<A.length){
            if(A[right]>=L &&A[right]<=R){
                res += right-left+1;
                right++;
            }else if(A[right]<L){
                int temp = right-1;
                while(temp>=left && A[temp]<L)
                    temp--;
                res += temp-left+1;
                right++;

            }else if(A[right]>R){
                left = right+1;
                right = left;
            }
        }

        return res;*/


        //方法二 利用公式  两个for循环
        //最大元素大于等于L小于等于R的子数组个数 = 最大元素小于等于R的子数组个数-最大元素大于L的子数组个数
        int res = 0;
        if(A==null || A.length<=0){
            return 0;
        }
        return numSubarrayBoundedMaxnum(A,R)-numSubarrayBoundedMaxnum(A,L-1);

    }

    private int numSubarrayBoundedMaxnum(int[] a, int i) {
        int temp = 0;
        int res = 0;
        for(int num:a){
            if(num<=i){
                temp++;
                res += temp;
            }else{
                temp = 0;
            }
        }
        return res;
    }
}
