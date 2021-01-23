/* 
Banner Start
Filename: Assemble.java,
Copyright 2020 
Version 8.0.0
Author: Team B5
Banner End 
*/

package project_B.V8;


import java.io.IOException;

public class Assemble {

	private static final Option help = new Option("help");
	private static final Option verbose = new Option("verbose");
	private static final Option banner = new Option("banner");
	private static final Option list = new Option("list");

	private static final IOptionTable listOfValideOptions = new OptionTable();
	private static String srcFileName;

	Assemble() {
		if (help.isValidOption())
			listOfValideOptions.add(help);
		if (verbose.isValidOption())
			listOfValideOptions.add(verbose);
		if (banner.isValidOption())
			listOfValideOptions.add(banner);
		if (list.isValidOption())
			listOfValideOptions.add(list);
	}

	public static void main(String[] args) throws IOException {
		
		Assemble assembleThisOjbect = new Assemble();  // added this to bc we need the if statement in the constructor

		IAdministrator admin = new Administrator(args, listOfValideOptions);
		admin.administer();

		srcFileName = admin.getCommandSrcFile();
		
		IOptionTable options = admin.getOptions(); //added today
		
		if(options.get("help").isEnabled()) { //added today
			admin.usage();
			System.exit(1);
		}
		
		if(options.get("banner").isEnabled()) // added today
		{
			System.out.println("Filename: Assemble.java,\r\n" + 
					"Version: 8.0.0,\r\n" + 
					"Year: 2020,\r\n" + 
					"Author: Team B5");	
		}
		

		LineStmtSeq seq = new LineStmtSeq();
		Link assemblyList = new Link(seq);
		//System.out.println();
		SourceFiles src = new SourceFiles(srcFileName);
		System.out.print(src.getAssemblyFile());
		String input_file = src.getAssemblyFile();
		Reader reader = new Reader(input_file);
		ISymbolTable keywordTable = new SymbolTable();

		Environment env = new Environment();
		env.getLexer().init(reader, keywordTable);

		Parser parser = new Parser(env);
		assemblyList.addLink(parser.parse());




		MakeFile fileMaker = new MakeFile(src.getSourceFile(), assemblyList.getseq());
		fileMaker.make(list.isValidOption());
	}
}
