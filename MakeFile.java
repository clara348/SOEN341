package project_B.V8;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Vector;


public class MakeFile {

    private String sourceName; // takes the name of the original file
    private File listingFile;
    private File executableFile;
    private LineStmtSeq lineStatements = new LineStmtSeq();
    private SymbolTable keyword = new SymbolTable();
    private Writer writer, writer1;
    private String generate="";


    public MakeFile(String sourceName, LineStmtSeq listOfLineStatements) {
        //super (listOfLineStatements);
        this.sourceName = sourceName;
        this.lineStatements = listOfLineStatements;

    }

    public void make(boolean listingEnabled) throws IOException {
        createListingFile(listingEnabled);
        createExecutableFile();

    }

    // generates the executable file
    private void createExecutableFile() throws IOException {
        //if (report.getErrorList() == null)
        //{
        System.out.println("Currently generating the executable file.....");
        executableFile = new File(sourceName + ".lst");
        // if creating the lst file is successful, then you can start to write in the lst file
        executableFile.delete();
        if (executableFile.createNewFile()) {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sourceName + ".asm"), "utf-8")); //create an object to write into the lst file

            String [] hex = generate.split(" ");

            for (int index = 0; index < hex.length; index++) {
                String hex1 = hex[index].trim();
                System.out.println(hex1);

                int i = Integer.parseInt(hex1, 16);
                String bin = Integer.toBinaryString(i);
                System.out.println(bin);

                writer.write(bin); // once the instruction is converted to binary it is written into the exe file
            }

            writer.close();

        }
    }


    // generates the listing file if "-l" option is enabled and you get this boolean from getEnabled() in Options Class
    private void createListingFile(boolean listingEnabled) throws IOException {
        if (listingEnabled) {
            try {
                // instantiate the File object and creates a new file with extension lst
                System.out.println("Currently generating the listing file....."); //prompts user file is being created
                listingFile = new File(sourceName + ".lst");
                // if creating the lst file is successful, then you can start to write in the lst file
                listingFile.delete();
                if (listingFile.createNewFile()) {


                    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sourceName + ".lst"), "utf-8")); //create an object to write into the lst file
                    String header = String.format("%-16s %-16s %-16s %-16s %-16s %-16s %-16s %-16s", "Line","Addr","Machine Inst","Machine Operand", "Label","Assembly Code", "Label Operand", "Comments"); // s string of the categories of the column
                    writer.write(header + "\n"); // prints the header

                    // create String objects to be reused inside the for loop below
                    String lineAddress;
                    String label1;
                    String opCode;
                    String offset;
                    String address;
                    String address1="";
                    String label2;
                    String assembly;
                    String comment;
                    String linout;
                    String string;
                    //String  binary;
                    // a vector of all the line statement
                    String operand="";

                    LineStmt myLine;
                    // loops through the vector to get each linestatement

                    for (int index = 0; index < lineStatements.size(); index++) {
                        LineStmt line = lineStatements.getLine(index);
                        lineAddress = String.format("%02X", line.lineAddress.getAddress());
                        if (line.inst != null) {
                            operand=address=offset="";
                            opCode = (line.inst.isOpcodeNull()) ? "" : String.format("%02X", line.inst.getOpCode());

                            offset = (line.inst.getOffset() == null) ? "" : String.format("%02X", line.inst.getOffset().getOffset());
                            if(offset.length()>2)
                            offset = offset.substring(offset.length() - 2);

                            address = (line.inst.getAddress() == null) ? "" : String.format("%04X", line.inst.getAddress().getAddress());
                            if(address.length()>4)
                             address = address.substring(address.length() - 4);
                            if(0< line.inst.getOpCode()&&line.inst.getOpCode() < 0xB0 && address.length()>2 )
                                address = address.substring(address.length() - 2);
                            if(address.length() == 4)
                                address = address.substring(0,2)+" "+address.substring(2,4);
                            assembly =  line.inst.getMnemonic();
                            label2 = (line.inst.getLabel() == null) ? "" : line.inst.getLabel().getLabelId();
                            if(offset.isEmpty())
                                operand=address;
                            else
                                operand =offset;

                            generate =  generate + " " +opCode.strip()+" "+address.strip()+" "+offset.strip();
                            if (line.inst.isOpcodeNull()) {
                                label2 = line.inst.getDirString();

                                opCode = generateString(label2);
                                generate = generate + opCode;
                            }


                        } else
                            opCode = offset = address = label2 = assembly = "";

                        label1 = (line.label == null) ? " " : line.label.getLabelId();
                        comment = (line.comment == null) ? "" : line.comment.getCommentString();
                        linout ="";

                        linout = String.format("%-16s %-16s %-16s %-16s %-16s %-16s %-16s %-16s", Integer.toString(index + 1), lineAddress, opCode, operand,label1,assembly,label2,comment);
                        linout += "\n";
                        System.out.print(linout);
                        if(listingEnabled)
                        writer.write(linout); // inserts the line into the lst file+ "\t\t\t\t"

                    }
                    generate = generate.trim().replaceAll("\\s{2,}", " ");
                    System.out.print("Generate: "+generate);
                    if(listingEnabled)
                    writer.write("Generate: "+generate);
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error: Listing File cannot be made.");
            }
        }
    }

    private String generateString(String string) {

        string = string.substring(1, string.length() - 1);
        char[] array = new char[string.length() + 1];
        array = string.toCharArray();
        string = "";
        for (int i = 0; i < array.length; i++) {
            string = string + String.format("%02X", (int) array[i]);
            string = string + " ";
        }
        string = string + String.format("%02X", 0);


        return string;


    }

}