package project_B.V8;
public class Opcode {

        private int opcode;

        public Opcode(int opCode) {
                this.opcode = opCode;
        }
        protected int getOpcode() {
                return opcode;
        }

        protected void setOpcode(int opcode) {
                this.opcode = opcode;
        }
}