package heima;

public class test_maxSubArray {
     public static int maxSubArray(int[] nums) {
            int res = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int temp = 0;
                int index = i;
                while(j>=index){
                    temp +=  nums[index++];
                }
                if(temp>res) res = temp;
            }
        }
        return res;
    }
         public static void main(String[] args){
            int[] nums = {1};
            
            int res = maxSubArray(nums);
            System.out.println(res);

         }
}
