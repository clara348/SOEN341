package project_B.V8;

public interface IAdministrator  {
    void administer();
    IOptionTable getOptions();
    void usage();
    String getCommandName();
    String getCommandOption();
    String  getCommandSrcFile();

}
