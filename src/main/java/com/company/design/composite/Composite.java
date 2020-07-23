package com.company.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 */
public class Composite {

    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode branch1 = new BranchNode("b1");
        BranchNode branch2 = new BranchNode("b2");
        BranchNode branch1_1 = new BranchNode("b1_1");
        BranchNode branch1_2 = new BranchNode("b1_2");
        BranchNode branch2_1 = new BranchNode("b2_1");
        LeafNode leafNode = new LeafNode("l1");
        LeafNode leafNode2 = new LeafNode("l2");

        root.add(branch1).add(branch2);
        branch1.add(branch1_1).add(branch1_2);
        branch2.add(branch2_1);
        branch2_1.add(leafNode2);
        branch1_2.add(leafNode);



        sort(root, 0);
    }

    private static void sort(Node root, int dept) {

        for (int i = 0; i < dept; i++) {
            System.out.print("--");
        }
        System.out.println(root.name);
        if (root instanceof BranchNode) {
            BranchNode b = (BranchNode) root;
            for (Node node : b.nodeList) {
                sort(node, dept + 1);
            }
        }


    }
}

abstract class Node {

    protected String name;
}

/**
 * 叶子节点
 */
class LeafNode extends Node {

    public LeafNode(String name) {
        this.name = name;
    }

    public void pri() {
        System.out.println(name);
    }
}

/**
 * 有子节点的Node
 */
class BranchNode extends Node {
    public BranchNode(String name) {
        this.name = name;
    }

    public void pri() {
        System.out.println(name);
    }

    public List<Node> nodeList = new ArrayList<>();

    public BranchNode add(Node node) {
        this.nodeList.add(node);
        return this;
    }
}


