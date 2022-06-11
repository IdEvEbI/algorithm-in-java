package com.idevebi.datastructures.hash.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 706. 设计哈希映射
 */
public class DesignHashmap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new DesignHashmap().new MyHashMap();

        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashMap {
        private int[] nodes = new int[1000001];

        public MyHashMap() {
            Arrays.fill(nodes, -1);
        }

        public void put(int key, int value) {
            nodes[key] = value;
        }

        public int get(int key) {
            return nodes[key];
        }

        public void remove(int key) {
            nodes[key] = -1;
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}