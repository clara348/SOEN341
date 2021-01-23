package project_B.V8;


public class Label extends Node {
	private String labelId = new String();


	int associated_address = 0;

	Label(Node node) {  //error constructor
		super(node);

	}
	Label(Node node, String labelId) {
		super(node);
		this.labelId = labelId;

	}

	public String getLabelId() {
		return labelId;
	}
}
