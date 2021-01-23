package project_B.V8;

import java.util.Vector;

public class Option {
	
	private final Vector<String> optionPseudo = new Vector<String>();
	private boolean validOption = true;
	private String optionName = new String();
	private boolean enabled = false;
	
	protected Option(String opt) {
		switch(opt){
			case ("help"):
				optionPseudo.add("-help");
				optionPseudo.add("-h");
				optionPseudo.add("-?");
				optionName = "help";
				enabled = false;
			break;
			case ("verbose"):
				optionPseudo.add("-verbose");
				optionPseudo.add("-v");
				optionName = "verbose";
				enabled = false;
				
			break;
			case ("banner"):
				optionPseudo.add("-banner");
				optionPseudo.add("-b");
				optionName = "banner";
				enabled = false;
			break;
			case ("list"):
				optionPseudo.add("-list");
				optionPseudo.add("-l");
				optionName = "list";
				enabled = false;
				break;
			default:
				validOption = false;
				enabled = false;
			break;
		}
		
	}
	protected boolean isValidOption() {
		return validOption;
	}
	
	
	protected String getOptionName() {
		return optionName;
	}
	
	protected Vector<String> getPseudo() {
		return optionPseudo;
	}
	
	protected boolean isEnabled() {
		return enabled;
	}
	
	protected void disabled() {
		enabled = false;
	}
	
	protected void enabled() {
		enabled = true;
	}
	
	
	protected void setOption(String option) {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.optionPseudo.size(); i++)
			if(this.optionPseudo.get(i).contentEquals(option)) {
				enabled();
				System.out.println("option match");
				System.out.println(this.getOptionName());
			}
				
	}
	
}
