package edu.umb.cs680.hw9.PrintingFramework;

import edu.umb.cs680.hw9.EncrptPass;
import edu.umb.cs680.hw9.SecurityContext;

public abstract class PrintJobExecutor {
    public void execute(Command job, EncrptPass pass, SecurityContext ctx){
        System.out.println("Processed for Printing");
        try{
            doAccessControl();
            doAuthentication(pass, ctx);
            doPrint(job);
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

    protected void doPrint(Command job){

    }


    protected void doErrorHandling(){

    }

}
