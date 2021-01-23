
package project_B.V8;


import java.util.Vector;


public class TranslationUnit extends Link {
	
	private Vector<String> character = new Vector<String>();

	
	public TranslationUnit(LineStmtSeq sequence) {
		super(sequence);
		lineStmtSeq.forwardPass();
		translateHex();
		translateBin();
		//object.pushLink(sequence);
	}

	public void translateHex(){
		String lineAddress;
		String label1;
		String opCode;
		String offset;
		String address;
		String label2;
		String assembly;
		String comment;
		String linout;
		String string;
		for(int i = 0; i < lineStmtSeq.size();i++){
			LineStmt line = lineStmtSeq.getLine(i);
			lineAddress = String.format("%02X",line.lineAddress.getAddress());
			if(line.inst != null) {

				opCode = (line.inst.isOpcodeNull()) ? "  " : String.format("%02X", line.inst.getOpCode());
				opCode = opCode.substring(opCode.length() - 2);

				offset = (line.inst.getOffset()== null) ? "  " : String.format("%02X", line.inst.getOffset().getOffset());
				offset = offset.substring(offset.length() - 2);

				address = (line.inst.getAddress() == null) ? "  " : String.format("%04X", line.inst.getAddress().getAddress());
				address = address.substring(address.length() - 2);
				assembly = (line.inst == null)?"\t":line.inst.getMnemonic();
				label2 = (line.inst.getLabel() == null) ? "     " : line.inst.getLabel().getLabelId();

				if(line.inst.isOpcodeNull()) {
					label2 = line.inst.getDirString();

					opCode = generateString(label2);
				}

			}
			else
				opCode = offset = address = label2 =assembly=" ";

			label1 = (line.label == null)?"\t":line.label.getLabelId();
			comment = (line.comment == null)?"":line.comment.getCommentString();


			linout = lineAddress+"   "+opCode+" "+offset+" "+address+" "+label1+"      "+assembly+"      "+ label2 +"      "+comment;

			System.out.println("2222222222222222");
		}

	}

	private String generateString(String string){

		string = string.substring(1,string.length()-1);
		char [] array = new char[string.length()+1];
		array = string.toCharArray();
		string = "";
		for(int i = 0; i < array.length; i++) {
			string = string + String.format("%02X",(int) array[i]);
			string = string + " ";
		}
		string = string + String.format("%02X",0);
		

		return string;


	}

	private void translateBin(){

	}
}
