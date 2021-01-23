package project_B.V8;

import java.util.Hashtable;

public interface ISymbolTable {
    public  abstract boolean isMnemonic(String s) ;

    public int getInt(String s) ;

    public String getOpcode(String s) ;

    public Hashtable<String, Integer> getMnemonics();


}
