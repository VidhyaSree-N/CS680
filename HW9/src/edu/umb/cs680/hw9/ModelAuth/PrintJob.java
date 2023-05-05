package edu.umb.cs680.hw9.ModelAuth;

import edu.umb.cs680.hw9.PrintingFramework.Command;

public class PrintJob implements Command {

    public PrintJob(){
    }

    Printer printer = Printer.getInstance();

    @Override
    public void execute() {
        printer.print();
    }
}
