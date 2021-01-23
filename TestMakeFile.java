package project_B.V8;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestMakeFile {

    public static void main(String[] args) throws IOException {

        // Foo halt ; this is a quick test
        //     push ; this is the end of the test

        // LineStmt<Foo, halt, this is a quick test>
        // LineStmt<, push, this is the end of the test>

        SourceFiles src = new SourceFiles();
        Reader reader = new Reader("project_B/V4/test_containg_errors.text");
        SymbolTable keywordTable = new SymbolTable();
        AssemblyUnit assemble = new AssemblyUnit();

        Environment env = new Environment();
        env.getLexer().init(reader, keywordTable);


        Parser parser = new Parser(env);
        //Link link = parser.parse();
       // LineStmtSeq result = link.getseq();
        //MakeFile makefile = new MakeFile("example_test", result);
        ErrorReporter error_reporter = new ErrorReporter();
        //makefile.createExecutableFile(error_reporter);

        File executableFile = new File("example_test.exe");
        Path fileName = Path.of("example_test.exe");
        String actual = Files.readString(fileName);
        System.out.println("This is the contents of example test!:");
        System.out.println(actual);
        System.out.println("Idk how to test that a binary is valid as expected....");

        // Full test for binary file:
        System.out.println("Test that the binary file has the expected content");
        System.out.println("110011001010001101101111110111111001100101100110010111000011101011110011110100010001011100110010");
        System.out.println(actual);

        System.out.println("Instead, lets verify that the listing file is correct!");
        //makefile.createListingFile(true);
        Path listingFileName = Path.of("example_test.lst");
        String listingString = Files.readString(listingFileName);
        System.out.println("Test that the listing file has the expected content");
        System.out.println(listingString);
        System.out.println("Almost the following: Line\tAddr\tMachine Code\tLabel\t\tAssembly Code\t\t;Comments\n" +
                "1\t\t0000\t\t\t\t\t\t\t\t̲Foo̲\t\t\t\t\t2\t\t0001\t\t\t\t\t\t\t\t\t\t\t\t\t3\t\t0002");
//
//
//        List<ErrorMessage> listOfErrors = error_reporter.getErrorList();
//
//        List<String> expected_errors = new ArrayList<String>();
//        expected_errors.add("ErrorReporter <Foo hult ; this is a quick test>");
//        expected_errors.add("ErrorReporter <pushE ; this is the end of the test>");
//
//        for (int i = 0; i < expected_errors.size(); i++) {
//            System.out.println("Test_that" + i + "_th error");
//
//            System.out.println(listOfErrors.get(i).message);
//            System.out.println(expected_errors.get(i));
//        }
    }
}
