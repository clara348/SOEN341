package project_B.V8;

public class Mnemonic extends Node {

    private String mnemonicId;
    private int opCode;

    public Mnemonic(Node node) { //error constructor on mnemonic
        super(node);
    }
    public Mnemonic(Node node, String mnemonicId, int opCode) {
        super(node);
        this.mnemonicId = mnemonicId;
        this.opCode = opCode;
    }


    public int getOpCode() {
        return opCode;
    }
    public void setOpCode(int opcode) {
        this.opCode=opcode;
    }

    public String getMnemonic() {
        if(mnemonicId==null)
            return "";
        return mnemonicId;
    }
}

