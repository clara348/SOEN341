package project_B.V8;

public class MachineCodeLine {
    Address address;
    Label label;
    Opcode opcode;
    int hex1;//2digits
    int hex2;//2digits
    int hex3;//2digits
    int hex4;//2digits

    public MachineCodeLine(Address address, int hex1, Opcode opcode){
        this.address=address;
        this.hex1 = hex1;
        this.opcode = opcode;
    }
    public MachineCodeLine(Address address, int hex1, int hex2, Opcode opcode){
        this.address=address;
        this.hex1 = hex1;
        this.hex2 = hex2;
        this.opcode = opcode;
    }
    public MachineCodeLine(Address address, int hex1, int hex2, int hex3, Opcode opcode){
        this.address=address;
        this.hex1 = hex1;
        this.hex2 = hex2;
        this.hex3 = hex3;
        this.opcode = opcode;
    }
    public MachineCodeLine(Address address, int hex1, int hex2, int hex3, int hex4, Opcode opcode) {
        this.address=address;
        this.hex1 = hex1;
        this.hex2 = hex2;
        this.hex3 = hex3;
        this.hex4 = hex4;
        this.opcode = opcode;
    }


    public String InstructionMnemonicToHex(Instruction instruction) {
        return String.format("%02x", instruction.getOpCode());
    }

    public String AddressToHex(Address address) {
        return String.format("%02x", address.getAddress());
    }


}
