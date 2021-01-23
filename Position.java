package project_B.V8;
public class Position {
	
	private  int line ;
	private  int column ;
	
	public Position(int line, int column) {
		this.line = line;
		this.column = column;
	}
	public Position() {

	}
	
	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
}
