package project_B.V8;

class  Administrator implements IAdministrator {

	private final String commandName;
	private String[] commandLine = new String[10];
	private final String commandOption = new String();
	private final String commandSrcFile = new String();
	private String  srcFile;


	//private String commandWcOO = new String();

	private IOptionTable listOfOptions =  new OptionTable();

	public String getCommandName()   	{return commandName ; }
	public String getCommandOption() 	{return commandOption ; }
	public String getCommandSrcFile()  	{return srcFile; }


	
	public Administrator(String[] args, IOptionTable OptionsList) {

		StackTraceElement[] stack = Thread.currentThread ().getStackTrace ();
		StackTraceElement main = stack[stack.length - 1];
		commandName = main.getClassName();
		commandLine = args;
		listOfOptions = OptionsList;

	}
	
	public void administer() {
		System.out.println("administer");
		if(parse()) {
			parseOption();
			parseCommandLine();
		}
	}

	protected boolean parse(){
 
		return (commandLine.length > 0);

	}
	
	protected void parseOption() {
		
		for(int k = 0; k < commandLine.length; k++) {
			listOfOptions.enableOption(commandLine[k]);
		}
	}
	
	protected void parseCommandLine() {
		String commandSrcFile="";
		srcFile ="";
		for(int k = 0; k < commandLine.length; k++) {
			if((commandLine[k].contains(".")) && (commandSrcFile.isEmpty()))
				srcFile = commandLine[k];

		}
	}
	
	public IOptionTable getOptions() {
		return listOfOptions;
	}
	
	public void usage() {
		
		String commandeUse = "CommandLine = CommandName { Option } { Argument } \r\n"; 
		String commandeExample =  "Example: "+ commandName +" -v  file.txt \r\n";
		

		
		String userMsg = commandeUse + commandeExample + 
				"Option =        || HelpOption | VerboseOption | BannerOption || \r\n" +
				"HelpOption =    ||   \"-?\"     |    \"-h\"       |   \"-help\"    || \r\n" +
				"VerboseOption = ||   \"-v\"     |  \"-verbose\"                  || \r\n" +
				"BannerOption =  ||   \"-b\"     |  \"-banner\"                   || \r\n"+
				"ListingOption = ||   \"-l\"     |  \"-listing\"                  || \r\n";
		System.out.println(userMsg);
		System.exit(1);
	}
	

}
