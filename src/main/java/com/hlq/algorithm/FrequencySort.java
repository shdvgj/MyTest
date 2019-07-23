package com.hlq.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:

输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:

输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:

输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。

 * @author Ricky
 *
 */
public class FrequencySort {
	public String frequencySort(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : chars) {
			Integer num = map.get(c);
			if (num == null) num = 0;
			num ++;
			map.put(c, num);
		}
		Set<Entry<Character, Integer>> entries = map.entrySet();
		List<Entry<Character, Integer>> mapList = new ArrayList<>();
		for (Entry<Character, Integer> entry : entries) mapList.add(entry);
		//将map中的数字进行重排序
		mapList.sort((a,b) -> {
			return b.getValue() - a.getValue();
		});
		StringBuilder str = new StringBuilder();
		mapList.forEach(entry -> {
			int size = entry.getValue();
			Character ch = entry.getKey();
			while (size > 0) {
				str.append(ch);
				size--;
			}
		});
		return str.toString();
	}
	
	public static void main(String[] args) {
		FrequencySort frequencySort = new FrequencySort();
		System.out.println(frequencySort.frequencySort("Integer"));
	}
}
