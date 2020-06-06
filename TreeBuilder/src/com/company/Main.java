package com.company;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree("d+e+f*e/(d+t)");
        tree.printTreePostfix();
        tree.printTreePrefix();
        tree.printTreeInfix();
    }
}
