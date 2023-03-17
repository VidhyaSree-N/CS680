package edu.umb.cs680.hw5.Printer;

import edu.umb.cs680.hw4.EncrptPass;
import edu.umb.cs680.hw4.SecurityContext;
import edu.umb.cs680.hw5.PrintJob;

public abstract class PrintJobExecutor {
    public void execute(PrintJob job, EncrptPass pass, SecurityContext ctx){
        System.out.println("Processed for Printing");
        try{
            doAccessControl();
            doAuthentication(pass, ctx);
            doPrint();
        }
        catch (Exception ex){
            doErrorHandling();
            throw ex;
        }
    }

    protected void doAuthentication(EncrptPass pass, SecurityContext ctx){

    }

    protected void doAccessControl(){

    }

    protected void doPrint(){

    }


    protected void doErrorHandling(){

    }

}
