package project_B.V8;

import java.util.Vector;


class  OptionTable implements IOptionTable {
	
	private final Vector<Option>  validOptions;

	public  OptionTable() {
		   validOptions = new Vector<Option>();
		   Option none = new Option("none");
		   validOptions.add(none);
	}

	public void add(Option opt) {
		   validOptions.add(opt);
	}
	
	public Vector<Option> getList() {
		return validOptions;
	}
	
	public void enableOption(String option) {	
		for(int i = 1; i < validOptions.size();i++)
			validOptions.get(i).setOption(option);
	}
	
	public Option get(String option) {
		for(int i = 1; i < validOptions.size();i++)
			if(validOptions.get(i).getOptionName().contentEquals(option))
				return validOptions.get(i);
		
		return validOptions.get(0);
	}
}
