package project_B.V8;

import java.util.Vector;

public class LineStmtSeq {

	public Vector<LineStmt> getVector() {
		return lineStmts;
	}

	private Address lineAddress = new Address(0);

	private  Vector<LineStmt> lineStmts = new Vector<LineStmt>();

	public LineStmtSeq() {

	}


	public void add(LineStmt lineStmt) {
		// TODO Auto-generated method stub

		Address address1 = new Address(1);
		Address address2 = new Address(2);
		Address address3 = new Address(3);
		lineStmt.setLineAddress(lineAddress);

		if(lineStmt.inst != null) {
			System.out.println("generating instruction memory allocation");
			System.out.println(lineStmt.inst.getOpCode());
			int opCode = lineStmt.inst.getOpCode();
			if (opCode == 0xD5 || opCode == 0xE7) {
				lineAddress = add(lineAddress, address3);
			} else if (opCode == 0xFF) {
				lineAddress = add(lineAddress, address2);
			} else if (-1 < opCode && opCode< 0xB0) {
				lineAddress = add(lineAddress, address1);
			} else  if (opCode < 0) {
				System.out.println("DIRECTIVE ADDRESS" + lineStmt.inst.getDirString().length());
				Address address = new Address(lineStmt.inst.getDirString().length() - 1);
				lineAddress = add(lineAddress, address);
			}
		}
		this.lineStmts.add(lineStmt);
	}

	private Address add(Address address1, Address address2) {
		System.out.println(address1.getAddress() +"  "+address2.getAddress());
		return new Address(address1.getAddress() + address2.getAddress());
	}

	public Vector<LineStmt> getLineStmt() {
		return lineStmts;

	}

	public void forwardPass(){

		int opCode = 0;
		int offset = 0;
		int address = 0;
		//lineStmts.get(0).setLineAddress(new Address(0));
		for (int i = 0; i < lineStmts.size(); i++) {
			if (lineStmts.get(i).inst != null) {
				if (lineStmts.get(i).inst.getLabel() != null) {
					String label = lineStmts.get(i).inst.getLabel().getLabelId();
					for (int j = 0; j < lineStmts.size(); j++) {
						if (i != j) {
							if (lineStmts.get(j).label != null) {
								if (label.equals(lineStmts.get(j).label.getLabelId())) {
									opCode = lineStmts.get(i).inst.getOpCode();
									if (0x2F < opCode && opCode < 0xB0) {

										offset = opCode + Math.abs(lineStmts.get(j).lineAddress.getAddress() - lineStmts.get(i).lineAddress.getAddress());

										if (j < i)
											offset = -offset;

										lineStmts.get(i).inst.setOpCode(new Opcode(offset));
									}
									if (0xD5 == opCode || opCode == 0xE7) {
										address = Math.abs(lineStmts.get(j).lineAddress.getAddress() - lineStmts.get(i).lineAddress.getAddress());


										if (j < i)
											address = -address;

										lineStmts.get(i).inst.setAddress(new Address(address));
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public LineStmt getLine(int i) {
		return lineStmts.get(i);
	}
	public int size() {
		return lineStmts.size();
	}


}