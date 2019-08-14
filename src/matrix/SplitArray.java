package matrix;

/**
 * 分隔数组 使得从第i个位置开始  后面的子数组元素 >= 前面的子数组元素
 * 返回i
 */
public class SplitArray {

    public static void main(String[] args) {
        int[] nums = {4,3,2,1,5,6,3,7,6,7};
        SplitArray sa = new SplitArray();

        System.out.print(sa.partitionDisjoint(nums));
    }

    public int partitionDisjoint(int[] A) {
        int max = A[0];
        int index = 1;
        return partition(A,max,index);

    }

    public int partition(int[] nums,int max,int index){
        boolean flag = true;
        int max1 = max;
        int i = index;
        while(i<nums.length){
            if(nums[i]<max){
                flag = false;
                i++;
                break;
            }else{
                max1 = Math.max(max1,nums[i]);
                i++;
            }
        }

        if(flag){
            //从index往后的元素都大于等于前面的元素  返回
            return index;
        }else{
            //
            return partition(nums,max1,i);
        }
    }

}
