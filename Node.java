package project_B.V8;

public class Node {

	protected String type;
	protected String value;
	protected int address;
	protected Position position = new Position();
	public Node() {

	}
	public Node(Node node) {
		this.type = node.type;
		this.value = node.value;
		this.position = node.position;
	}
	public Node(String type, Position pos) {
		this.type = type;
		this.position  = pos;
	}
	public Node(String type, Position pos, int address) {
		this.type = type;
		this.value = value;
		this.position  = pos;
		this.address = address;
	}

	protected Position getPosition() {
		return position;
	}
	protected String getType() { return type; }
	protected String getValue() { return value; }

}
