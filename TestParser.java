package project_B.V8;

/*
public class TestParser {
    public static void main(String[] args) throws IOException {

        // Foo halt ; this is a quick test
        //     push ; this is the end of the test

        // LineStmt<Foo, halt, this is a quick test>
        // LineStmt<, push, this is the end of the test>

        SourceFiles src = new SourceFiles();
        Reader reader = new Reader("test.txt");
        SymbolTable keywordTable = new SymbolTable();
        AssemblyUnit assemble = new AssemblyUnit();
        
        Environment env = new Environment();
        env.getLexer().init(reader, keywordTable);


        Parser parser = new Parser(env);
        Link link = parser.parse();
        LineStmtSeq result = link.getseq();

        // LineStmt<label,Foo,this is a quick test>
        Vector<LineStmt> listOfLines= result.getVector();

        List<String> expected_lines = new ArrayList<String>();
        expected_lines.add("LineStmt<Foo, Instruction<br.i5, 2>, this is a quick test>");
        expected_lines.add("LineStmt<, Instruction<push>, this is the end of the test>");

        for (int i = 0; i < listOfLines.size(); i++) {
            System.out.println("Test_that" + i + "_th line is correct");

            String expected_line = "";
            if (i < expected_lines.size()) {
                expected_line = expected_lines.get(i);
            }
            System.out.println(expected_line); // "LineStmt<Foo, push, Here we push>"
            System.out.println(listOfLines.get(i).stringRepresentation());
        }
    }
}
*/