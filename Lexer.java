package project_B.V8;

import java.io.IOException;

public class Lexer implements ILexer {



	int linePos;
	int colPos;
	int curlinePos;
	int curcolPos;
	int ch;
	Reader reader = new Reader();
	ISymbolTable keywordTable = new SymbolTable();
	private String sLexer = new String();
	private final int 	 LABEL = 1, MNEMONIC = 2,  COMMENT = 3 ,  NUMBER = 4 ,EOL= 5,ERROR = 6,EOF = 7 , DIR = 8,STR=9;



	Lexer(){


	}

	public void init(Reader reader, ISymbolTable keywordTable) throws IOException {

		linePos = 1;
		colPos = 0;
		curlinePos = linePos;
		curcolPos = colPos;
		this.reader = reader;
		this.keywordTable = keywordTable;

		read();

	}

	private int read(){

		if(ch == -1)
			reader.close();

		colPos++;
		return ch = reader.read();
	}

	public String getString(){
		return sLexer;
	}

	public Token getToken() {
		// TODO Auto-generated method stub


		sLexer ="";


		if(ch == -1 ) {
			return new Token(EOF);
		}


		while ( ch == ' ' || ch == '\t'|| ch == '\n' || ch == 13 ) {

			if(ch == '\n'){
				colPos = 0;
				linePos++;
			}
			if(ch == '\n'  ) {
				read();
				return new Token(EOL);
			}
			if(ch == -1 ) {
				return new Token(EOF);
			}
			read();

			//	return new Token(EOL);
		}



		// Mark position (after skipping blanks)
		curlinePos = linePos;
		curcolPos = colPos;

		while (true) {
			switch ( ch ) {
				case EOF:
					return new Token(EOF);

				case 'a': case 'b': case 'c': case 'd': case 'e':
				case 'f': case 'g': case 'h': case 'i': case 'j':
				case 'k': case 'l': case 'm': case 'n': case 'o':
				case 'p': case 'q': case 'r': case 's': case 't':
				case 'u': case 'v': case 'w': case 'x': case 'y':
				case 'z':
				case 'A': case 'B': case 'C': case 'D': case 'E':
				case 'F': case 'G': case 'H': case 'I': case 'J':
				case 'K': case 'L': case 'M': case 'N': case 'O':
				case 'P': case 'Q': case 'R': case 'S': case 'T':
				case 'U': case 'V': case 'W': case 'X': case 'Y':
				case '_':
				case 'Z':
					return scanIdentifier();

				case '.':  /* dot for directives as a first character */
					return scanDirective();


				case '0': case '1': case '2': case '3': case '4':
				case '5': case '6': case '7': case '8': case '9':
				case '-':
					return scanNumber();
				//case ',':
				//	read(); return COMMA;
				case '\"':
					return scanString();

				case ';':
					return scanComment();

				case '\n': case '\r':
					return new Token(EOL);

				default:
					read(); break;
			}
		}
	}

	/*
	token types EOF = 6, EOL= 0, LABEL = 1, MNEMONIC =2, NUMBER = 3, COMMENT = 4, ERROR = 5 ;
	 */

	private Token scanNumber() {
		StringBuilder sb = new StringBuilder();
		//System.out.println("number");
		if (ch == '-') {

			sb.append((char) ch);
			read();
		}

		while (ch > 47 && ch < 58) {
			sb.append((char) ch);
			read();
		}

		sLexer = sb.toString();

		if(sLexer.equals("-"))
			return new Token(ERROR);

		return new Token(NUMBER);





	}

	private Token scanIdentifier(){
		curlinePos = linePos;
		curcolPos = colPos;
		//System.out.println(curcolPos);
		sLexer ="";
		StringBuilder sb = new StringBuilder();
		while((ch !=' ') &&  (ch!='\t') && (ch!='\n') && (ch!=13)) {
			sb.append((char)ch);
			read();
		}
		sLexer = sb.toString();
		//System.out.println("Lexr:" + sLexer);

		if(keywordTable.isMnemonic(sLexer)) {
			//System.out.println("MNemonic");
			return new Token(MNEMONIC);

		}
		return new Token(LABEL);
	}

	private Token scanComment() {

		sLexer = "";
		StringBuilder sb = new StringBuilder();
		while ( (ch != '\n') && (ch!=13)) {
			sb.append((char)ch);
			read();
		}
		sLexer = sb.toString();
		//System.out.println("COMMENT");
		return new Token(COMMENT);
	}

	private Token scanDirective() {

		sLexer = "";
		StringBuilder sb = new StringBuilder();
		if (ch == '.') {

			sb.append((char) ch);
			read();
		}
		while((ch !=' ') &&  (ch!='\t') && (ch!='\n') && (ch!=13)) {
			sb.append((char)ch);
			read();
		}
		sLexer = sb.toString();
		//System.out.println("COMMENT");
		return new Token(DIR);


	}
	private Token scanString(){

		StringBuilder sb = new StringBuilder();
		sb.append((char) ch);
		read();

		while((ch!='\n') && (ch!=13) && ch != '\"' && (19 < ch) && (ch < 80)) {
			sb.append((char)ch);
			read();
		}
		if (ch == '\"') {
			sb.append((char) ch);
			read();
		}
		sLexer = sb.toString();
		return new Token(STR);
	}

	public int getLine() {return curlinePos;}

	public int getColumn(){return curcolPos;}

	private  void makeTable(){

	//	Keyword halt  = new Keyword(Halt, Opcode.halt);
	//	Keyword pop   = new Keyword(Pop, Opcode.pop);
	//	Keyword dup   = new Keyword(Dup, Opcode.dup);

	}


}