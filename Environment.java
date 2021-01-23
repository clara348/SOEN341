package project_B.V8;

import project_B.V4.ErrorMessage;

public class Environment {

	private final Lexer lexer;
	private final SymbolTable symTable;

	private final ErrorReporter errorReporter;
	private final ErrorMessage error;
	
	public Environment() {
		errorReporter = new ErrorReporter();
		error = new ErrorMessage("");
		lexer = new Lexer();
		symTable = new SymbolTable();
	}
	public Lexer getLexer() {
		return lexer;

	}
	public SymbolTable getSymbolTable() {
		return symTable;

	}

	public ErrorReporter getErrorReporter(){
		return errorReporter;
	}
	
	

}
