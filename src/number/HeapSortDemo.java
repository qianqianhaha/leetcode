package number;

public class HeapSortDemo {

    private static int len;
    public static void main(String[] args) {
        int[] nums = {10,9,8,7,6,5,4,3,2,1};
        HeapSortDemo heapSortDemo = new HeapSortDemo();
        heapSortDemo.heapSort(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public void heapSort(int[] nums){
        len = nums.length;
        maxHeapfy(nums);

        for(int i=0;i<nums.length;i++){
            swap(nums,0,nums.length-1-i);
            len--;
            maxHeapfy(nums);

        }

    }

    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }

    private void maxHeapfy(int[] nums) {
        for(int i=len/2-1;i>=0;i--){
            int index = i;
            int max = nums[i];
            if(2*i+1<len && nums[2*i+1]>max){
                index = 2*i+1;
                max = nums[2*i+1];
            }

            if(2*i+2<len && nums[2*i+2]>max){
                index = 2*i+2;
                max = nums[2*i+2];
            }
            if(index!=i){
                swap(nums,i,index);
            }
        }
    }

}
