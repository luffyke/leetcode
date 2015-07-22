package com.smartx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b><code>Leetcode3</code></b>
 * <p>
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * </p>
 * <b>Creation Time:</b> 2015年6月25日 上午11:37:54
 * @author kext
 * @since mdoctor 1.0
 */
public class Leetcode3 {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		char[] chars = s.toCharArray();
		int[] indexs = new int[127];
		for (int i = 0; i < indexs.length; i++) {
			indexs[i] = -1;
		}
		int max = 0;
		int moveIndex = 0;
		for (int i = 0; i < chars.length; i++) {
			if (indexs[chars[i]] < 0) {
				// 说明之前没出现过该字符，赋值标记为当前index，随着i的递增，max也递增
				indexs[chars[i]] = i;
			} else {
				// 说明出现过该字符，开始移动moveIndex，比较上一个该值的index + 1和moveIndex大小
				moveIndex = Math.max(moveIndex, indexs[chars[i]] + 1);
				// 赋值标记为当前index，为比较当前index和moveIndex准备
				indexs[chars[i]] = i;
			}
			// 比较max和i - moveIndex + 1的大小
			max = Math.max(max, i - moveIndex + 1);
		}
		return max;
	}

	// Time Limit Exceeded
	public int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
		char[] chars = s.toCharArray();
		int result = 1;
		for (int i = 0; i < chars.length - 1; i++) {
			List<Character> cList = new ArrayList<Character>();
			cList.add(chars[i]);
			map.put(i, cList);
			for (int k = i + 1; k < chars.length; k++) {
				if (!map.get(i).contains(chars[k])) {
					map.get(i).add(chars[k]);
					if (map.get(i).size() > result) {
						result = map.get(i).size();
						if (map.get(i).size() == chars.length) {
							return chars.length;
						}
					}
				} else {
					break;
				}
			}
		}
		return result;
	}
}
