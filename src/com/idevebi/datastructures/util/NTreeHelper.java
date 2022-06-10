package com.idevebi.datastructures.util;

import com.idevebi.datastructures.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class NTreeHelper {

    /**
     * 创建测试 N Tree
     * <p>
     * [1]
     * [3 2 4]
     * [5 6] [x] [8]
     * [x] [x] [9]
     *
     * @return 根节点
     */
    public static Node createTestNTree() {

        // 1. 第 4 层
        List<Node> layer4List = new ArrayList<>();
        layer4List.add(new Node(9));

        List<Node> layer43List = new ArrayList<>();
        layer43List.add(new Node(8, layer4List));

        // 2. 第 3 层
        List<Node> layer3List = new ArrayList<>();
        layer3List.add(new Node(5));
        layer3List.add(new Node(6));

        // 3. 第二层
        List<Node> layer2List = new ArrayList<>();
        layer2List.add(new Node(3, layer3List));
        layer2List.add(new Node(2));
        layer2List.add(new Node(4, layer43List));

        // 4. 根节点
        Node root = new Node(1, layer2List);

        return root;
    }
}
