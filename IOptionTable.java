package project_B.V8;

import java.util.Vector;

public interface IOptionTable{
		
	public abstract void add(Option opt);
	public abstract void enableOption(String option);
	public abstract Option get(String option);
	public abstract Vector<Option> getList();
	
}
