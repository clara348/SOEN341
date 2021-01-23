package project_B.V8;

public class Comment extends Node {
	private String commentString = new String();

	public Comment(Node node) {   //error constructor
		super(node);
	}

	public Comment(Node node, String commentString) {
		super(node);
		this.commentString = commentString;

	}



	public String getCommentString() {
		return commentString;
	}
}

