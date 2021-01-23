package project_B.V8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader implements IReader {
	FileInputStream srcStream ;
	private int c;
	private final int EOF = -1;

	Reader(){

	}

	public Reader(String assemblyFile) {
		File srcFile = new File(assemblyFile);

		System.out.println(assemblyFile);
		if(!srcFile.exists()) { 

			System.out.print("No such file or directory");
			System.exit(1);
		}
		try {
			srcStream = new FileInputStream (srcFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int read()  {


		try {
			c = srcStream.read();

			if(c == EOF) {
				srcStream.close();
				return c;
				
			}



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (char)c;

	}
	public void close()  {

		try {
			System.out.println("file closed good night");
			srcStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}