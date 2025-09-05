class Solution {
    public int[] sortArrayByParity(int[] nums) {
       int arr[]=new int[nums.length];
       int left = 0;
       int right = nums.length-1;
       for(int num : nums){
        if(num % 2 ==0){
            arr[left]= num;
            left++;
        }
        else{
            arr[right]=num;
            right--;
        }
       } 
       return arr;
    }
}