class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0, current = 0;

        for (int num : nums) {
            if (num == 0) {
                current++;       
                count += current; 
            } else {
                current = 0;     
            }
        }

        return count;
    }
}