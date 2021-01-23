package project_B.V8;

public class NumberNode extends Node {

    private int number;

    public NumberNode(Node node, int number) {
        super(node);
        this.number = number;

    }
    public NumberNode(Node node) {
        super(node);
        this.number = -1000;  //not a valid number node;

    }

    public int getNumber() {
        return number;
    }
}
