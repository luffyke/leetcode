package com.smartx;

/**
 * <b><code>Leetcode1</code></b>
 * <p>
 * 
 * </p>
 * @author kext
 */
public class Leetcode1 {

	public static void main(String[] args) {
		int[] nums = { 2, 11, 7, 15 };
		int target = 18;
		int[] result = twoSum(nums, target);
		System.out.println("index1=" + result[0] + ", index2=" + result[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i + 1;
					result[1] = j + 1;
					break;
				}
			}
		}
		return result;
	}
}
