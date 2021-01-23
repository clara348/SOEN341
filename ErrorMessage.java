package project_B.V8;


public class ErrorMessage {
	
	public String message = "";
	//Token token;
	//Token pos;
	
	public ErrorMessage(String message){
		this.message = message;
	}
	
	//ErrorMessage(String error){
	//	this.message = error;
	//	}
	
	public String create(String t, Position p) {
		
		//t=this.token.getTokenType();
		//p=this.pos.getTokenPos();
		//return "Error Message " + token + "at position " + pos;
		this.message = "Error Message " + t + "at Line: " + p.getLine() + " Column: "+p.getColumn();
		
		System.out.println(message);
		
		return message;
	}
}