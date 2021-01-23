package project_B.V8;


public class Instruction extends Node {

	private String mnemonic;
	private Opcode opCode = null ;
	private Label label = null;
	private Address address = null;
	private Offset offset = null;
	private String dirString = new String();


	//private String dString = null;

	public Instruction(Node node) {  //if error in sequence no Mnemonic constructor ;
		super(node);
	}

	public Instruction(Node node, Opcode opCode, String mnemonic) {
		super(node);
		this.opCode = opCode;
		this.mnemonic = mnemonic;
	}

	public Instruction(Node node, String mnemonic) {
		super(node);
		this.mnemonic = mnemonic;
	}


	public String getMnemonic() {
		return mnemonic;
	}

	public String getDirString() {
		return dirString;
	}

	public void setDirString(String dirString) {
		this.dirString = dirString;
	}


	public int getOpCode() {
		if(opCode == null)
			return -1;
		return opCode.getOpcode();
	}

	public void setOpCode(Opcode opCode) {
		this.opCode = opCode;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Offset getOffset() {
		return offset;
	}

	public void setOffset(int offset) {

		this.offset = new Offset(offset);

	}
	public boolean isOpcodeNull() {
		return (opCode == null)?true:false;
	}

	//public String stringRepresentation() {
	//	return "Instruction<"+this.getMnemonic()+", "+this.getOperand()+">";
	//}


}
