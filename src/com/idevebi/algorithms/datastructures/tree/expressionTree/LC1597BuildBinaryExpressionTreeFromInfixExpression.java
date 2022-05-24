package com.idevebi.algorithms.datastructures.tree.expressionTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 根据中缀表达式构造二叉表达式树
 *
 * <a href="https://leetcode.cn/problems/build-binary-expression-tree-from-infix-expression/">https://leetcode.cn/problems/build-binary-expression-tree-from-infix-expression/</a>
 */
public class LC1597BuildBinaryExpressionTreeFromInfixExpression {
    public static void main(String[] args) {
        String s = "2-3/(5*2)+1";
        ExpressionTree tree = new ExpressionTree();

        tree.root = tree.expTree(s);

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
        System.out.println();
        System.out.println();
    }
}

class ExpressionTree {

    Node root;

    /**
     * 前序遍历
     */
    public void preorder(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(n.val + " ");
        preorder(n.left);
        preorder(n.right);
    }

    public void inorder(Node n) {
        if (n == null) {
            return;
        }
        inorder(n.left);
        System.out.print(n.val + " ");
        inorder(n.right);
    }

    public void postorder(Node n) {
        if (n == null) {
            return;
        }
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.val + " ");
    }

    /**
     * 根据中缀表达式构造二叉表达式树
     *
     * @param s 中缀表达式
     * @return 二叉表达式树的根节点
     */
    public Node expTree(String s) {
        if (s.length() == 0) {
            return null;
        }

        // 数字栈
        Deque<Node> numStack = new LinkedList<>();
        // 操作符栈
        Deque<Character> opStack = new LinkedList<>();

        // 遍历字符串
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                // 1. 如果是数字，直接入栈
                numStack.push(new Node(c));
            } else if (c == '(') {
                // 括号直接入栈
                opStack.push(c);
            } else if (c == ')') {
                // 3. 处理括号
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    createSubTree(numStack, opStack);
                }
                // 直接把 '(' 出栈
                opStack.pop();
            } else if (c != ' ') {
                // 处理运算符
                while (!opStack.isEmpty() && priority(c) <= priority(opStack.peek())) {
                    createSubTree(numStack, opStack);
                }

                // 2. 新运算符入栈
                opStack.push(c);
            }
        }

        // 4. 处理栈中剩余数据
        while (!opStack.isEmpty()) {
            createSubTree(numStack, opStack);
        }

        return numStack.pop();
    }

    private void createSubTree(Deque<Node> numStack, Deque<Character> opStack) {
        Node n = new Node(opStack.pop());

        n.right = numStack.pop();
        n.left = numStack.pop();

        numStack.push(n);
    }

    private int priority(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }
}

class Node {
    char val;
    Node left;
    Node right;

    Node() {
        this.val = ' ';
    }

    Node(char val) {
        this.val = val;
    }

    Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
