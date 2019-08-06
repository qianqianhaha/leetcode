package number;

import java.util.Arrays;

/**
 * H指数计算：
 * 输入：0 1 3 5 6
 *
 */
public class HIndex {

    public static void main(String[] args) {
        HIndex hi = new HIndex();
        int[] citations = {100};
        System.out.println(hi.hIndex(citations));

    }

    public int hIndex(int[] citations) {
        int res = 0;
        if(citations==null || citations.length<=0)
            return res;
        int sum = 1;

        Arrays.sort(citations);

        for(int i=citations.length-1;i>=0;i--){
            if(citations[i]>=sum){
                if(i==0){
                    res = sum;
                }else if(citations[i-1]<=sum)
                    res = sum;
            }
            sum++;

        }
        return res;
    }

}
