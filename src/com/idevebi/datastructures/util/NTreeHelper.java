package com.idevebi.datastructures.util;

import com.idevebi.datastructures.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class NTreeHelper {

    /**
     * 创建测试 N Tree
     *
     * 1
     * 3 2 4
     * 5 6
     *
     * @return 根节点
     */
    public static Node createTestNTree() {

        // 1. 第 3 层
        List<Node> layer3List = new ArrayList<>();
        layer3List.add(new Node(5));
        layer3List.add(new Node(6));

        // 2. 第二层
        List<Node> layer2List = new ArrayList<>();
        layer2List.add(new Node(3, layer3List));
        layer2List.add(new Node(2));
        layer2List.add(new Node(4));

        // 3. 根节点
        Node root = new Node(1, layer2List);

        return root;
    }
}
