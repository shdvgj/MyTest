package com.hlq.algorithm;

/**
 * 排序算法总结
 * @author Ricky
 *
 */
public class SortSumarry {
	// 冒泡排序 时间复杂度o(n^2)
	public static void bubbleSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j] < nums[j-1]) {
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
				}
			}
		}
	}
	
	public static void bubbleSort_2(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j] < nums[j-1]) {
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
				}
			}
		}
	}
	
	// 选择排序
	// 每次找到队列中最小的放在最前面，时间复杂度O(n^2)
	public static void selectionSort(int[] nums) {
		int minIndex = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[minIndex] > nums[j]) {
					minIndex = j; // 获取最小的数
				}
			}
			int temp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = temp;
		}
	}
	
	// 计数排序和桶排序类似
	// 需要确定最大值，将每个数位的数字进行遍历
	public static void countSort(int[] nums,int max) {
	}
	
	public static void quickSort_2(int a[] , int left , int right) {
		if (left > right) return;
		int temp = a[left];
		int i = left;
		int j = right;
		while(i!=j) {
			while(a[j] >= temp && i < j) j--;
			while(a[i] <= temp && i < j) i++;
			if (i < j) {
				int t = a[j];
				a[j] = a[i];
				a[i] = t;
			}
		}
		a[left] = a[i];
		a[i] = temp;
		quickSort_2(a, left, i-1);
		quickSort_2(a, i+1, right);
	}
	
	// 快速排序
	public static void quickSort(int a[], int left, int right) {
		int i, j, t, temp;
		if (left > right)
			return;

		temp = a[left]; // temp中存的就是基准数
		i = left;
		j = right;
		while (i != j) {
			// 顺序很重要，要先从右边开始找
			while (a[j] >= temp && i < j)
				j--;
			// 再找右边的
			while (a[i] <= temp && i < j)
				i++;
			// 交换两个数在数组中的位置
			if (i < j) {
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		// 最终将基准数归位
		a[left] = a[i];
		a[i] = temp;

		quickSort(a, left, i - 1);// 继续处理左边的，这里是一个递归的过程
		quickSort(a, i + 1, right);// 继续处理右边的 ，这里是一个递归的过程
	}
	
	// 归并排序
	public static void mergeSort(int[] arr, int low, int high) {
		//使用递归的方式进行归并排序，所需要的空间复杂度是O（N+logN）
        int mid = (low + high)/2;
        if(low < high)
        {
            //递归地对左右两边进行排序
        	mergeSort(arr, low, mid);
        	mergeSort(arr, mid+1, high);
            //合并
            merge(arr, low, mid, high);
        }
	}
	
	//merge函数实际上是将两个有序数组合并成一个有序数组
    //因为数组有序，合并很简单，只要维护几个指针就可以了
    private static void merge(int[] arr, int low, int mid, int high)
    {
        //temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int i = low;
        //右半边的指针
        int j = mid+1;
        //合并后数组的指针
        int k = 0;
        
        //将记录由小到大地放进temp数组
        for(; i <= mid && j <= high; k++)
        {
            if(arr[i] < arr[j])
                temp[k] = arr[i++];
            else
                temp[k] = arr[j++];
        }
        
        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while(i <= mid)
            temp[k++] = arr[i++];
        
        while(j <= high)
            temp[k++] = arr[j++];
        
        //将temp数组中的元素写入到待排数组中
        for(int l = 0; l < temp.length; l++)
            arr[low + l] = temp[l];
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {7,4,9,3,6,2};
		//bubbleSort(nums);
		//selectionSort(nums);
		quickSort_2(nums, 0, nums.length-1);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
