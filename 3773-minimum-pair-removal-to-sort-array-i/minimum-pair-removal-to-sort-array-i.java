
class Solution {
    public void operations(int[] nums, int size) {
        int min_value = nums[0] + nums[1];
        int min_index = 0;
        for (int i = 0; i < size - 1; i++) {
            int cal_value = nums[i] + nums[i + 1];
            if (cal_value < min_value) {
                min_value = cal_value;
                min_index = i;
            }
        }
        nums[min_index] = min_value;
        for (int i = min_index + 1; i < size - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int cnt = 0;
        int size = nums.length;
        if (size <= 0)
            return cnt;
        while (true) {
            boolean sorted = true;
            for (int i = 0; i < size - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    sorted = false;
                    break;
                }
            }
            
            if (!sorted) {
                cnt++;
                operations(nums, size);
                size--;
            }
            else break;
        }
        return cnt;
    }
}