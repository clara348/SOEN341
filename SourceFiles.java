package project_B.V8;

import java.io.File;
import java.util.Vector;

public class SourceFiles {

	private String sourceFile;
	private String extension;
	private final String lstExt = ".lst";
	private final String exeExt = ".exe";

	private String fullSourceFileName;
	public SourceFiles()
	{
		sourceFile = null;
		extension = null;
		fullSourceFileName = null;
	}
	
	private Vector<SourceFiles> storageFile; //stores the files
	

	
	SourceFiles (String source)
	{
		fullSourceFileName = source;

		File srcFile1 = new File(source);
		if(!srcFile1.exists()) {
			System.out.print("No such file or directory");
			System.exit(1);
		}
		String [] srcFile = fullSourceFileName.split("\\.");

		System.out.println(srcFile[0] );
		System.out.println(srcFile[1]);
		sourceFile = srcFile[0];
		extension = srcFile[1];

	}
	
	public String getSourceFile ()
	{
		return sourceFile; 
	}
	
	public String getExtension () { return extension; }
	public String getExeExtension () { return exeExt; }
	public String getLstExtension () { return lstExt; }

	public String getSourceName ()
	{
		return fullSourceFileName; 
	}
	
	public void setsourceName (String x, String y)
	{
		fullSourceFileName = x+y; 
	}
	
	public void setSourceFile (String x)
	{
		sourceFile = x; 
	}
	
	public void setExtension (String x)
	{
		extension = x; 
	}
	
	
	public void addFile (SourceFiles sourceFile)
	{
		storageFile.add(sourceFile);
	}
	
	public void printAllFilesInStorage()
	{
		for (int x = 0; x < storageFile.size(); x++)
		{
			System.out.println(storageFile.get(x).getSourceName());
		}
	}
	
	public void createFile (String myFile) // creates the listing and the executable file
	{
		
	}
	
	public String getAssemblyFile() { return fullSourceFileName; }
	//public String getmnemonicFile() { return mnemonicFile; }

	//private final String AssemblyFile = "assembly.txt";
	//private final String mnemonicFile =  "assembly.txt";



}
