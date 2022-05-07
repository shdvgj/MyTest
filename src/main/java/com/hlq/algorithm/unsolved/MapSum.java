package com.hlq.algorithm.unsolved;


import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 *     MapSum() 初始化 MapSum 对象
 *     void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 *     int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * inputs = ["MapSum", "insert", "sum", "insert", "sum"]
 * inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 *
 *
 * 提示：
 *
 *     1 <= key.length, prefix.length <= 50
 *     key 和 prefix 仅由小写英文字母组成
 *     1 <= val <= 1000
 *     最多调用 50 次 insert 和 sum
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/z1R5dt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MapSum {
    // 前缀树没完成
    class TreeNode {
        int val = 0;
        TreeNode[] next;
    }

    TreeNode[] loopNode;

    Map<String, Integer> stringMap;

    public MapSum() {
        loopNode = new TreeNode[26];
        stringMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        stringMap.put(key, val);
        char[] chars = key.toCharArray();
        for (char aChar : chars) {
            loopNode[aChar - 96].val += val;
            loopNode = loopNode[aChar - 96].next;
            if (loopNode == null) {
                loopNode = new TreeNode[26];
            }
        }
    }

    public int sum(String prefix) {
        char[] chars = prefix.toCharArray();
        int result = 0;
        for (char aChar : chars) {
            TreeNode treeNode = loopNode[aChar - 96];
            if (treeNode.val == 0) return 0;
            result += treeNode.val;
            loopNode = treeNode.next;
            if (loopNode == null) return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("app",3);
        mapSum.insert("apple",3);
        mapSum.insert("appstore",3);
        System.out.println(mapSum.sum("app"));
    }

    /*
    暴力解法，遍历map的key是否包含前缀进行累加
    Map<String, Integer> initMap;

    *//** Initialize your data structure here. *//*
    public MapSum() {
        initMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        initMap.put(key, val);
    }

    public int sum(String prefix) {
        int result = 0;
        Set<String> set = initMap.keySet();
        for (String s : set) {
            if (s.startsWith(prefix)) result += initMap.get(s);
        }
        return result;
    }*/
}
