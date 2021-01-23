package project_B.V8;

import java.util.Hashtable;

public class SymbolTable implements ISymbolTable {

    private final Hashtable<String, Integer> mnemonics = new Hashtable<String, Integer>();

    public Hashtable<String, Integer> getMnemonics() { return mnemonics; }

    public SymbolTable() {

        mnemonics.put("halt", 0x00);
        mnemonics.put("pop",  0x01);
        mnemonics.put("dup",  0x02);
        mnemonics.put("exit", 0x03);
        mnemonics.put("ret",  0x04);
        mnemonics.put("not", 0x0C);
        mnemonics.put("and", 0x0D);
        mnemonics.put("or",  0x0E);
        mnemonics.put("xor", 0x0F);
        mnemonics.put("neg", 0x10);
        mnemonics.put("inc", 0x11);
        mnemonics.put("dec", 0x12);
        mnemonics.put("add", 0x13);
        mnemonics.put("sub", 0x14);
        mnemonics.put("mul", 0x15);
        mnemonics.put("div", 0x16);
        mnemonics.put("rem", 0x17);
        mnemonics.put("shl", 0x18);
        mnemonics.put("shr", 0x19);
        mnemonics.put("teq", 0x1A);
        mnemonics.put("tne", 0x1B);
        mnemonics.put("tlt", 0x1C);
        mnemonics.put("tgt", 0x1D);
        mnemonics.put("tle", 0x1E);
        mnemonics.put("tge", 0x1F);

        mnemonics.put("br.i5", 0x30);
        mnemonics.put("brf.i5", 0x50);
        mnemonics.put("ldc.i3",  0x90);
        mnemonics.put("addv.u3",  0x98);
        mnemonics.put("ldv.u3",   0xA0);
        mnemonics.put("stv.u3",   0xA8);
        mnemonics.put("enter.u5", 0x70);

        mnemonics.put("lda.i16",0xD5);
        mnemonics.put("call.i16",0xE7);
        mnemonics.put("trap",0xFF);

    }



    public boolean isMnemonic(String s) {
        return (mnemonics.containsKey(s));
    }

    public int getInt(String s) {

        if (isMnemonic(s))
            return mnemonics.get(s);

        return -1;
    }

    public String getOpcode(String s) {

        if (isMnemonic(s))
            return String.format("%02X", mnemonics.get(s));

        return "";
    }



    public void makeTable() {

    }
}
