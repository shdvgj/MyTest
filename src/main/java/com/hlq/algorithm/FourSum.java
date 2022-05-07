package com.hlq.algorithm;

import java.util.*;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 *     0 <= a, b, c, d < n
 *     a、b、c 和 d 互不相同
 *     nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * 你可以按 任意顺序 返回答案 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 200
 *     -10^9 <= nums[i] <= 10^9
 *     -10^9 <= target <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {
    /**
     * 思路：将数组内的数两两相加，得出所有的两数相加的组合，将结果和下标记录在一个map中
     * 再遍历相加后等于target的两数组合，将组合里的下标取出，进行去重后放入到结果集中
     * 无法通过测试，显示超时
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> preHandleMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int twoSum = nums[i]+nums[j];
                if (!preHandleMap.containsKey(twoSum)) {
                    List<Integer> twoNum = Arrays.asList(i,j);
                    List<List<Integer>> list = new ArrayList<>();
                    list.add(twoNum);
                    preHandleMap.put(twoSum, list);
                } else {
                    List<List<Integer>> list = preHandleMap.get(twoSum);
                    List<Integer> twoNum = Arrays.asList(i,j);
                    list.add(twoNum);
                    preHandleMap.put(twoSum, list);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> keySet = preHandleMap.keySet();
        Set<Integer> passSet = new HashSet<>();
        Set<String> otherPassSet = new HashSet<>();
        for (Integer integer : keySet) {
            Integer otherNum = target - integer;
            if (passSet.contains(integer) || passSet.contains(otherNum)) continue;
            passSet.add(integer);
            passSet.add(otherNum);
            if (preHandleMap.containsKey(otherNum)) {
                List<List<Integer>> oneList = preHandleMap.get(integer);
                List<List<Integer>> otherList = preHandleMap.get(otherNum);
                for (List<Integer> ones : oneList) {
                    int i = ones.get(0);
                    int j = ones.get(1);
                    for (List<Integer> twos : otherList) {
                        int m = twos.get(0);
                        int n = twos.get(1);
                        if (i != m && i != n && j != m && j != n) {
                            int[] arr = new int[]{nums[i],nums[j],nums[m],nums[n]};
                            Arrays.sort(arr);
                            String strKey = "" + arr[0] + arr[1] + arr[2] + arr[3];
                            if (otherPassSet.contains(strKey)) continue;
                            otherPassSet.add(strKey);
                            List<Integer> singleResult = Arrays.asList(nums[i],nums[j],nums[m],nums[n]);
                            result.add(singleResult);
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum_v2(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i-1] == nums[i]) continue;
            for (int j = i+1; j < len - 2; j++) {
                if (j > i + 1 && nums[j-1] == nums[j]) continue;
                int twoSum = nums[i] + nums[j];
                int left = j + 1, right = len - 1;
                while (left < right) {
                    if (twoSum + nums[left] + nums[right] == target) {
                        List<Integer> single = Arrays.asList(nums[i],nums[j],nums[left],nums[right]);
                        resultList.add(single);
                        if (nums[left] == nums[right]) break;
                        do {
                            left++;
                        } while (nums[left-1] == nums[left] && left < right);
                        do {
                            right--;
                        } while (nums[right+1] == nums[right] && left < right);
                        continue;
                    }
                    if (twoSum + nums[left] + nums[right] > target) right--;
                    else left ++;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum_v2(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90, 90}
                , 200));
    }

}
