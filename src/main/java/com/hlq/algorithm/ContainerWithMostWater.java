package com.hlq.algorithm;

/**
 * 
 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例:  
      1 2 3 4 5 6 7 8 9
输入: [1,8,6,2,5,4,8,3,7]
(index1 - index0) * (min(int[index1],int[index0]))
输出: 49
 * @author Ricky
 *
 */
public class ContainerWithMostWater {
	
	// 暴力法
	public int maxArea(int[] height) {
		int left = 0;
		int right = 0;
		int maxArea = 0;
		int temp = 0;
		for (int i = 0; i < height.length - 1; i++) {
			left = height[i];
			for (int j = i + 1; j < height.length; j++) {
				right = height[j];
				temp = (left > right ? right : left) * (j - i);
				if (temp > maxArea) {
					maxArea = temp;
				}
			}
		}
		return maxArea;
	}
	
	// 双指针法
	// 将一个指针放在头部 ， 一个放在尾部 ， 每次算得面积后 ， 将高度较小的指针往中间移动
	// 原因 ： 面积的高度由较低的高度决定
	public int maxArea_V2(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int maxArea = 0;
		int temp = 0;
		while(i != j) {
			int heightMin = 0;
			int width = j - i;
			if (height[i] > height[j]) {
				heightMin = height[j];
				j--;
			} else {
				heightMin = height[i];
				i++;
			}
			temp = heightMin * width;
			if (temp > maxArea) maxArea = temp;
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
		System.out.println(containerWithMostWater.maxArea_V2(new int[] {1,8,6,2,5,4,8,3,7}));
	}
}
