package project_B.V8;

import java.util.Vector;

public  class  Parser implements IParser {

	public Parser(Environment env) {

		this.lexer = env.getLexer();
		this.errorReporter = env.getErrorReporter();
		this.keywordTable = env.getSymbolTable();

		// this.errorReporter = env.getErrorReporter();
		// this.table = env.getSymbolTable();
		nextToken(); // prime


		// address = 0;
	}

	// Record the error: <t> expected, found <token> at <token>.position
	protected void expect(int t) {

		if (expect != curToken) {
			int expect = curToken;
			//System.out.println(expected +"=="+t);
			//System.out.println( _Error.create( (t+" expected "), pos));
			errorReporter.error(new ErrorMessage(t + " expected " + pos));
		}
		/*
		nextToken();

		 */
	}

	public LineStmtSeq parse() {
		System.out.println("Parsing a AssemblyUnit...");

		LineStmtSeq seq = new LineStmtSeq();

		while (token.getToken() != EOF) {
			seq.add(parseLineStmt());
		}
		// return new Link(seq);
		//return new TranslationUnit(seq);
		seq.forwardPass();
		return seq;
	}

	//---------------------------------------------------------------------------------


	private Label parseLabel() {
		//System.out.println("in parse Label");


		Label label = (curToken == LABEL) ? makeLabel() : new Label(makeError());
		tokenizer();

		return label;
	}
	private Instruction makeDirective() {
		//System.out.println("in parse mnemonic");

		return new Instruction(node,mnemonic);
	}
	private Instruction parseDirective() {


		Instruction inst= makeDirective();
		System.out.println("this:"+tokenName[curToken]);
		System.out.println("this:"+parsedString);
		tokenizer();
		System.out.println("this:"+tokenName[curToken]);
		System.out.println("this:"+parsedString);
		if (curToken == STR) {
			System.out.println(parsedString);
			inst.setDirString(parsedString);
			System.out.println(inst.getDirString());
		}
		tokenizer();

		return inst;

	}
	private Instruction parseInstDir() {

		opCode = (curToken == MNEMONIC) ? (keywordTable.getInt(parsedString)) : -1;
		if(curToken == DIR ) return parseDirective();

		if(curToken == COMMENT ||curToken == EOL) return null;

		if (0x00  <= opCode && opCode <  0x20)   return parseInherent();
		if (0x2F  <  opCode && opCode <  0xB0)   return parseImmediate();
		if (0xAF  <  opCode && opCode <= 0xFF)   return parseRelative();

		tokenizer();

		return new Instruction(makeError());

	}
	private Instruction parseInherent() {
		//System.out.println("in parse inherent");

		Instruction inst = makeInstruction(parsedString);
		tokenizer();
		return inst;
	}

	private Instruction parseImmediate() {
		Instruction inst = null;
		String mnemonic = parsedString;
		int vOpcode = opCode;
		expect = ( 0x6F < opCode && opCode < 0xB0) ? NUMBER : LABEL;

		tokenizer();


		if(curToken != expect )
			inst =  new Instruction(makeError());

		else if (curToken == NUMBER) {
			numberOp = Integer.parseInt(parsedString);
			if(validateNumber(vOpcode,numberOp)) {
				opCode = vOpcode + numberOp;
				inst = makeInstruction(mnemonic);
			}
			else
				inst =  new Instruction(makeError());
		}

		else if(curToken == LABEL) {
			inst = makeInstruction(mnemonic);
			inst.setLabel(makeLabel());
		}
		tokenizer();
		return inst;

	}
	private boolean validateNumber(int vOpcode,int numberOp){

		switch (vOpcode) {

			case 0x98: case 0xA0: case 0xA8: return (-1 < numberOp && numberOp < 8)?true:false;
			case 0x30: case 0x50: return (-9 < numberOp && numberOp < 8)?true:false;
			case 0x90: return (-5 < numberOp && numberOp < 4)?singed():false;
			case 0x70: return (-1 < numberOp && numberOp < 32)?true:false;
			case 0xFF: return (-1 < numberOp && numberOp < 256)?true:false;

			default: return false;
		}
		//return false; 
	}

	private boolean singed(){
		if(numberOp<0)
			numberOp = 8+numberOp;
		return true;
	}



	//---------------------------------------------------------------------------------


	//---------------------------------------------------------------------------------
	private Instruction parseRelative() {

		Instruction inst = null;
		String mnemonic = parsedString;
		int vOpcode = opCode;
		expect = ( 0xD5 == opCode || opCode == 0xEF) ? LABEL: NUMBER;

		tokenizer();

		if(curToken != expect || (curToken == NUMBER && !validateNumber(vOpcode,Integer.parseInt(parsedString))))
			inst =  new Instruction(makeError());

		if (curToken == NUMBER) {

			inst = makeInstruction(mnemonic);
			System.out.println(parsedString);
			inst.setOffset((Integer.parseInt(parsedString)));

		}
		if(curToken == LABEL) {
			inst = makeInstruction(mnemonic);
			inst.setLabel(makeLabel());
		}
		tokenizer();

		return inst;
	}

	private Instruction makeInstruction(String mnemonic) {
		//System.out.println("in parse mnemonic");

		return new Instruction(node,new Opcode(opCode),mnemonic);
	}

	private Label makeLabel(){
		return new Label(node, parsedString);
	}


	private Comment parseComment() {
		if(count == 0)
			count++;
		Comment comment = null;
		if (curToken == COMMENT)
			comment = new Comment(node, parsedString);

		expect = EOL;
		tokenizer();
		return comment;
	}

	private void EOL(){
		while(curToken != EOL && curToken != EOF){
			nextToken();

		}
	}

	private Node makeError(){
		return new Node(parseError(), pos);
	}
	private String parseError() {
		//System.out.println("error:" + tokenName[_eToken]);
		String error = "["+parsedString+"]"+"[L:" + pos.getLine() + "C:" + pos.getColumn() +"]"+ tokenName[curToken] ;
		return error;
	}


	private void cashToken() {

		curToken = token.getToken();
		parsedString = lexer.getString();
		pos = new Position(lexer.getLine(), lexer.getColumn());
		node = new Node(tokenName[curToken], pos);
		//mnemonic = (curToken == MNEMONIC ||curToken == DIR )?parsedString:"";

		if(curToken==STR)
			System.out.println(parsedString);

	}

	private void cashout() {


		parsedString = "";
		pos = new Position();
		node = new Node();
		opCode = -1;
	}
	private void tokenizer(){
		if(curToken != EOL && curToken != EOF)
			nextToken();
		else
			cashout();


	}

	//System.out.println("toke"+curToken+ "S:" +parsedString)}


	// -------------------------------------------------------------------
	// A line statement:
	//   - could be empty (only a EOL);
	//   - could have a single comment start at BOL or after a label, label/inst, or label/dir;
	//   - could have a label only, etc.
	//
	// LineStatement = [Label] [Instruction | Directive ] [Comment] EOL .
	//
	public LineStmt parseLineStmt() {

		Label label = null;
		Instruction inst = null;
		Comment comment = null;

		System.out.println(tokenName[curToken]);
		comment = (count == 0) ? parseComment() : comment;
		label = (pos.getColumn() == 1) ? parseLabel() : label;
		inst = (curToken != EOL) ? parseInstDir() : inst;
		comment = (curToken != EOL) ? parseComment() : comment;
		System.out.println("toke:" + tokenName[curToken]);

		while (curToken != EOL && curToken != EOF)
			nextToken();

		if (curToken == EOL)
			nextToken();


		return new LineStmt(label, inst, comment);
	}

	protected void nextToken() {
		token = lexer.getToken();
		cashToken();

	}


	private final Position dpos = new Position(0, 0);
	private Vector<Node> vNode  = new Vector<Node>();
	private  Position pos;
	protected int address = 0;
	protected String parsedString = "";
	private Token token;
	private final Lexer lexer;
	private final ErrorReporter errorReporter;
	private final ErrorMessage _Error = new ErrorMessage("");
	private final SymbolTable keywordTable;
	private final int 	 LABEL = 1, MNEMONIC = 2,  COMMENT = 3 ,  NUMBER = 4 ,EOL= 5,ERROR = 6,EOF = 7 , DIR = 8,STR=9;
	private final String[] tokenName={"empty","LABEL", "MNEMONIC","COMMENT", "NUMBER","EOL","ERROR","EOF","DIRECTIVE","STRING"};
	private int curToken;
	private int expect;
	private int numberOp;
	//int expectNext;
	//int tokenIs;
	private Vector<LineStmt> lines = new Vector<LineStmt>();
	private int opCode;
	Node node = null;
	private int offset;
	private int count=0;
	String mnemonic;
	private Vector<Label> labels = new Vector<Label>();
}
