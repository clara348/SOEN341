package project_B.V8;

public class LineStmt {

	protected Label label = null;
	protected Instruction inst = null;
	protected Comment comment = null;
	protected Address lineAddress = null;

	int size_of_machine_code = 0;

	public LineStmt(Label label, Instruction inst, Comment comment) {
		this.label = label;
		this.inst = inst;
		this.comment = comment;

	}
	public LineStmt() {

	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Instruction getInst() {
		return inst;
	}

	public void setInst(Instruction inst) {
		this.inst = inst;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Address getLineAddress() {
		return lineAddress;
	}

	public void setLineAddress(Address lineAddress) {
		this.lineAddress = lineAddress;
	}

	public int getSize_of_machine_code() {
		return size_of_machine_code;
	}

	public void setSize_of_machine_code(int size_of_machine_code) {
		this.size_of_machine_code = size_of_machine_code;
	}
}
/*

	public String getLabel() {
		if(label == null)
			return "";
		return label.getLabelId();
	}


	public String getInst() {
		if(inst == null)
			return "";
		return inst.getMnemonic();
	}
	public String getOperand() {
		if(inst == null)
			return "";
	//	return inst.getOperand();
	}
	public String opCode() {
		if(inst == null)
			return "";
		String hex = String.format("%02X", inst.getOpcode());
		hex = hex.substring(hex.length()-2);
		return hex;
	}
	

	public String getComment() {
		if(comment == null)
			return "";
		return comment.getCommentString();
	}

	public int getAddress() {

		if (inst != null)
			return inst.getAddress();
		return 0;

	}
	public String getOffset() {
		if(inst == null)
			return "";
		String hex = String.format("%02X", inst.getOffset());
		hex = hex.substring(hex.length()-2);
		return hex;
	}

	
	

}

 */