package project_B.V8;


public class  Link {

	protected LineStmtSeq lineStmtSeq;
	
	//public Vector<LineStmtSeq> allLineStatementsLinked = new Vector <LineStmtSeq>();
	
	public Link(LineStmtSeq seq) {
		lineStmtSeq = seq;	
		
	}

    public LineStmtSeq getseq() {
		return lineStmtSeq;
	}


	public void addLink(LineStmtSeq seq) {
		lineStmtSeq = seq;

	}
	/*
    public pushLink(LineStmtSeq linkElement)
    {
    	lineStmtSeq = linkElement;
    	allLineStatementsLinked.addElement(lineStmtSeq); 
    }
*/
	/*private LineStmtSeq lineStmtSeq = new LineStmtSeq();
>>>>>>> 82fcafc1ac01488fbe4470c784f48d275d228708
	
	public Link(LineStmtSeq seq) {
		// TODO Auto-generated constructor stub
		lineStmtSeq = seq;
		
		
	}


    public LineStmtSeq getseq() {
		return lineStmtSeq;
	}
	*/
}
