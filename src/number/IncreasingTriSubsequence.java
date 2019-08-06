package number;

public class IncreasingTriSubsequence {

    public static void main(String[] args) {
        int[] nums = {2,4,-2,-3};
        IncreasingTriSubsequence its = new IncreasingTriSubsequence();
        System.out.println(its.increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        //boolean res = false;
        if(nums.length>=3){
            int index = 0;
            while(index<nums.length-2){
                if(nums[index+1]<=nums[index]){
                    index++;
                    continue;
                }
                //可能找到了第一个数了,下一个数从index+1 开始搜索
                int index2 = index+1;
                while(index2<nums.length-1){
                    int temp = nums[index2];
                    if(temp<=nums[index]){
                        index2++;
                        continue;
                    }
                    for(int i=index2+1;i<nums.length;i++){
                        if(nums[i]>temp)
                            return true;
                    }
                    index2++;
                }
                index++;

            }

        }

        return false;
    }
}
