class Solution {
    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }

    public static void main(String[] args) {
        int[] testCases = {16, 5, 1, 64, 0, -4};

        for (int n : testCases) {
            System.out.println("Input: " + n + " -> Output: " + isPowerOfFour(n));
        }
    }
}