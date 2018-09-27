public class PartitionEqualSubsetSum {
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = half; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[half];
    }
}