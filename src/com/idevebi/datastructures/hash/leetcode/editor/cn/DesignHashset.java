package com.idevebi.datastructures.hash.leetcode.editor.cn;

/**
 * 705. 设计哈希集合
 * <p>
 * 参考资料：<a href="https://leetcode.cn/problems/design-hashset/solution/yi-ti-san-jie-jian-dan-shu-zu-lian-biao-nj3dg/">https://leetcode.cn/problems/design-hashset/solution/yi-ti-san-jie-jian-dan-shu-zu-lian-biao-nj3dg/</a>
 */
public class DesignHashset {
    public static void main(String[] args) {
        MyHashSet myHashSet = new DesignHashset().new MyHashSet();

        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyHashSet {
        /**
         * 根据题目规则，用空间换时间
         */
        private boolean[] nodes = new boolean[1000009];

        /**
         * 构造器
         */
        public MyHashSet() {

        }

        public void add(int key) {
            nodes[key] = true;
        }

        public void remove(int key) {
            nodes[key] = false;
        }

        public boolean contains(int key) {
            return nodes[key];
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}