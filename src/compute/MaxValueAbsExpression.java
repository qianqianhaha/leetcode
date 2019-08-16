package compute;

/**
 * 1131. 绝对值表达式的最大值
 * 给你两个长度相等的整数数组，返回下面表达式的最大值：
 *
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 *
 * 其中下标 i，j 满足 0 <= i, j < arr1.length。
 *
 * 思路  去绝对值符号
 * 1） a1[i]-a1[j]+a2[i]-a2[j]+i-j  = a1[i]+a2[i]+i - (a1[j]+a2[j]+j)  =  Max(A) - Min(A)=X1;  A=a1[i]+a2[i]+i   (把索引一样的提到一起)
 * 2） a1[i]-a1[j]+a2[i]-a2[j]+j-i  = a1[i]+a2[i]-i - (a1[j]+a2[j]-j)  =  Max(B) - Min(B)=X2;  B=a1[i]+a2[i]-i
 * 3)  a1[i]-a1[j]+a2[j]-a2[i]+i-j  = a1[i]-a2[i]+i - (a1[j]-a2[j]+j)  =  Max(C) - Min(C)=X3;  C=a1[i]-a2[i]+i
 * 4)  a1[i]-a1[j]+a2[j]-a2[i]+j-i  = a1[i]-a2[i]-i - (a1[j]-a2[j]-j)  =  Max(D) - Min(D)=X4;  D=a1[i]-a2[i]-i
 *
 * res = Max(X1,X2,X3,X4)
 *
 */
public class MaxValueAbsExpression {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int max_a = Integer.MIN_VALUE;
        int min_a = Integer.MAX_VALUE;
        int max_b = Integer.MIN_VALUE;
        int min_b = Integer.MAX_VALUE;
        int max_c = Integer.MIN_VALUE;
        int min_c = Integer.MAX_VALUE;
        int max_d = Integer.MIN_VALUE;
        int min_d = Integer.MAX_VALUE;

        for(int i=0;i<arr1.length;i++){
            max_a = Math.max(max_a,arr1[i]+arr2[i]+i);
            min_a = Math.min(min_a,arr1[i]+arr2[i]+i);
            max_b = Math.max(max_b,arr1[i]+arr2[i]-i);
            min_b = Math.min(min_b,arr1[i]+arr2[i]-i);
            max_c = Math.max(max_c,arr1[i]-arr2[i]+i);
            min_c = Math.min(min_c,arr1[i]-arr2[i]+i);
            max_d = Math.max(max_d,arr1[i]-arr2[i]-i);
            min_d = Math.min(min_d,arr1[i]-arr2[i]-i);

        }

        int temp1 = Math.max(max_a-min_a,max_b-min_b);
        int temp2 = Math.max(max_c-min_c,max_d-min_d);

        return Math.max(temp1,temp2);
    }

}
