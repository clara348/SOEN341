package project_B.V8;


import java.util.ArrayList;
import java.util.List;

//record and report errors in ErrorReporter
public class ErrorReporter {

	private final List<ErrorMessage> errorList;
	public void report() {
		for (int i=0; i<errorList.size(); i++) {
			System.out.println(errorList.get(i).message);
		}
		System.out.println("no more errors");
	}

	public ErrorReporter(){
		this.errorList = new ArrayList();
	}

	public void error(ErrorMessage message) {
		errorList.add(message); 
	}


    public List <ErrorMessage> getErrorList() {
		return errorList;
    }

}
