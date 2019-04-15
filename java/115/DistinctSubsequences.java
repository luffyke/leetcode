public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] nums = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            nums[0][i] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            nums[i][0] = 0;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    nums[i][j] = nums[i][j - 1] + nums[i - 1][j - 1];
                } else {
                    nums[i][j] = nums[i][j - 1];
                }
            }
        }
        return nums[t.length()][s.length()];
    }
}
