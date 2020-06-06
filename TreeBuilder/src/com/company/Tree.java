package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Tree {

    Node root;

    ArrayList<String> operators = new ArrayList<>();

    Tree(String expression) {
        operators.addAll(Arrays.asList("(", ")", "+", "-", "*", "/"));
        buildTree(expression);
    }

    public void printTreePostfix() {
        System.out.println(root.printPostfix(""));
    }

    public void printTreePrefix() {
        System.out.println(root.printPrefix(""));
    }

    public void printTreeInfix() {
        System.out.println(root.printInfix(""));
    }

    void buildTree(String expression) {
        Stack<Node> values = new Stack<>();
        Stack<String> symbols = new Stack<>();
        char[] chars = expression.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            String symbol = Character.toString(chars[i]);
            if (chars[i] >= 97 && chars[i] <= 122) {
                values.add(new Node(symbol));
            } else if (symbol.equals("(")) {
                symbols.add(symbol);
            } else if (symbol.equals(")")) {
                while (!symbols.lastElement().equals("(")) {
                    Node newNode = getNewSubtree(new Node(symbols.pop()), values.pop(), values.pop());
                    values.add(newNode);
                }
                symbols.pop();
            } else if (operators.contains(symbol)) {
                if (symbols.size() == 0) {
                    symbols.add(symbol);
                    continue;
                }
                while (symbols.size() != 0 && (operators.indexOf(symbol) / 2 <= operators.indexOf(symbols.lastElement()) / 2)) {
                    Node newNode = getNewSubtree(new Node(symbols.pop()), values.pop(), values.pop());
                    values.add(newNode);
                }
                symbols.add(symbol);

            }
        }

        while (symbols.size() != 0) {
            Node newNode = getNewSubtree(new Node(symbols.pop()), values.pop(), values.pop());
            values.add(newNode);
        }

        this.root = values.pop();
    }

    private Node getNewSubtree(Node root, Node node1, Node node2) {
        root.left = node2;
        root.right = node1;
        return root;
    }
}

class Node {
    String value;
    Node left, right;


    String printPostfix(String output) {
        if (left != null)
            output = left.printPostfix(output);
        if (right != null)
            output = right.printPostfix(output);

        output += value;
        return output;
    }

    String printPrefix(String output) {

        output += value;
        if (left != null)
            output = left.printPrefix(output);
        if (right != null)
            output = right.printPrefix(output);

        return output;
    }

    String printInfix(String output) {
        output += (left != null || right != null) ? "(" : "";
        if (left != null)
            output = left.printInfix(output);

        output += value;

        if (right != null)
            output = right.printInfix(output);

        output += (left != null || right != null) ? ")" : "";
        return output;
    }

    Node(String value) {
        this.value = value;
    }
}
