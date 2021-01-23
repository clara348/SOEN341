package project_B.V8;//; TestImmediate.asm - Test assembly file for Immediate instructions.
//        Mnemonic number    operand
//        ldc.i3  -4       ; OK, number <i3> [-4..3].
//        ldc.i3  3        ; OK, number <i3> [-4..3].
//        ldc.i3  4        ; Error, number not in range <i3> [-4..3].

//        ldv.u3  0        ; OK, number <u3> [0..7].
//        ldv.u3  7        ; OK, number <u3> [0..7].
//        ldv.u3  -1       ; Error, number not in range <u3> [0..7].
//
//        stv.u3  0        ; OK, number <u3> [0..7].
//        stv.u3  7        ; OK, number <u3> [0..7].
//        stv.u3  -1       ; Error, number not in range <u3> [0..7].
//
//        addv.u3  0        ; OK, number <u3> [0..7].
//        addv.u3  7        ; OK, number <u3> [0..7].
//        addv.u3  -1       ; Error, number not in range <u3> [0..7].
//
//        enter.u5  0        ; OK, number <u5> [0..31].
//        enter.u5  0        ; OK, number <u5> [0..31].
//        enter.u5  -1       ; Error, number not in range <u5> [0..15].
/*

public class TestParsingImmediateInstruction {
    public static void main(String[] args) throws IOException {
        // read test.txt file
        SourceFiles src = new SourceFiles();
        Reader reader = new Reader("test_paring_immediate_instruction.txt");
        SymbolTable keywordTable = new SymbolTable();
        AssemblyUnit assemble = new AssemblyUnit();

        Environment env = new Environment();
        env.getLexer().init(reader, keywordTable);

        Parser parser = new Parser(env);
        try {
            Link link = parser.parse();//TEST passes only if parser throws an exception
            System.out.println("Nothing broke.... this is UNEXPECTED");
        } catch (Exception exception) {
            System.out.println("Something broke.... hopefully the number is out of range...");
            exception.message.contains("range"); // we are checking that the parser gave us an error message related to the range
        }

        LineStmtSeq result = link.getseq();

    }
}*/