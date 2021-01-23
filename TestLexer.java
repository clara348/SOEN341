package project_B.V8;
/*
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestLexer {
    public static void main(String[] args) throws IOException {
        // read test.txt file
        Lexer lexer = new Lexer();
        Reader reader = new Reader("test.txt"); // <- Ami, provide a proper reader
        SymbolTable symbolTable = new SymbolTable(); // <- Ami, provide a proper symbol table
        lexer.init(reader, symbolTable);

        // read all tokens
        List<Token> read_tokens = new ArrayList<Token>();
//        while (1 == 0) { // <- Ami, provide proper termination
//            Token token = new Token("a", "b", new Position(1,2), 3);
//        	read_tokens.add(token); // <- Ami, get token from lexer
//        }

        // expect that the result == 
        List<Token> expected_tokens = new ArrayList<Token>();
        expected_tokens.add(new Token(NType.LABEL, "Foo", new Position(1,1)));
        expected_tokens.add(new Token(NType.INSTRUCTION, "halt", new Position(1,2)));
        expected_tokens.add(new Token(NType.COMMENT, "this is a quick test", new Position(1,2)));
        expected_tokens.add(new Token(NType.INSTRUCTION, "push", new Position(1,2)));
        expected_tokens.add(new Token(NType.COMMENT, "this is the end of the test", new Position(1,2)));



        for (int i = 0; i < read_tokens.size(); i++) {
        	System.out.println("Test_that i_th token is correct");
			System.out.println(expected_tokens.get(i));
			System.out.println(read_tokens.get(i).getTokenValue());
		}

    }
}

*/