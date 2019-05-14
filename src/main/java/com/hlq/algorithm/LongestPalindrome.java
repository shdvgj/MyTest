package com.hlq.algorithm;

/**
 * 
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 * @author Ricky
 *
 */
public class LongestPalindrome {
	/**
	 * abccba
	 * abcdecba
	 * aba
	 * abaacdef
	 * fedcaaba
	 * 反转算法 ， 即先将字符串反转 ， 然后找出跟原字符串相等的部分 ， 在比较字符串的索引位置 ， 判断是否是回文
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		StringBuilder bd = new StringBuilder(s);
		//反转
		bd.reverse();
		// 如果反转字符串完全相等 ， 直接返回
		if(bd.toString().equals(s)) return s;
		int len = s.length();
		String result = "";
		int resultLength = 0;
		for(int i = 0 ; i < len - resultLength; i++) {
			// 截取比现有最大长度大的位置
			for(int j = i + resultLength + 1; j <= len ; j++) {
				String palindromeStr = s.substring(i, j);
				// 在反转字符串内查找相同的字符串
				int index = bd.indexOf(palindromeStr);
				if (index >= 0 
					// 判断下标相等即为回文
					&& len - j == index) {
					result = palindromeStr;
					resultLength = result.length();
				} 
				// 如果cde找不到的话 ， 那cdef肯定也找不到 ， 所以直接break
				else if (index < 0) break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		LongestPalindrome longestPalindrome = new LongestPalindrome();
		System.out.println(longestPalindrome.longestPalindrome("abb"));
		System.out.println(longestPalindrome.longestPalindrome("ukxidnpsdfwieixhjnannbmtppviyppjgbsludrzdleei"
				+ "ydzawnfmiiztsjqqqnthwinsqnrhfjxtklvbozkaeetmblqbxbugxycrlzizthtuwxlmgfjokhqjyukrftvfwikxlp"
				+ "tydybmmzdhworzlaeztwsjyqnshggxdsjrzazphugckgykzhqkdrleaueuajjdpgagwtueoyybzanrvrgevolwssvq"
				+ "imgzpkxehnunycmlnetfaflhusauopyizbcpntywntadciopanyjoamoyexaxulzrktneytynmheigspgyhkelxgwp"
				+ "lizyszcwdixzgxzgxiawstbnpjezxinyowmqsysazgwxpthloegxvezsxcvorzquzdtfcvckjpewowazuaynfpxsxr"
				+ "ihsfswrmuvluwbdazmcealapulnahgdxxycizeqelesvshkgpavihywwlhdfopmmbwegibxhluantulnccqieyrbjj"
				+ "qtlgkpfezpxmlwpyohdyftzgbeoioquxpnrwrgzlhtlgyfwxtqcgkzcuuwagmlvgiwrhnredtulxudrmepbunyamss"
				+ "rfwyvgabbcfzzjayccvvwxzbfgeglqmuogqmhkjebehtwnmxotjwjszvrvpfpafwomlyqsgnysydfdlbbltlwugtap"
				+ "wgfnsiqxcnmdlrxoodkhaaaiioqglgeyuxqefdxbqbgbltrxcnihfwnzevvtkkvtejtecqyhqwjnnwfrzptzhdnmvs"
				+ "jnnsnixovnotugpzuymkjplctzqbfkdbeinvtgdpcbvzrmxdqthgorpaimpsaenmnyuyoqjqqrtcwiejutafyqmfau"
				+ "ufwripmpcoknzyphratopyuadgsfrsrqkfwkdlvuzyepsiolpxkbijqw"));
	}

}
