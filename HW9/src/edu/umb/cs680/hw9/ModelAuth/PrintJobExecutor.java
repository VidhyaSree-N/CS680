package edu.umb.cs680.hw9.ModelAuth;

import edu.umb.cs680.hw9.*;
import edu.umb.cs680.hw9.PrintingFramework.Command;

public class PrintJobExecutor extends edu.umb.cs680.hw9.PrintingFramework.PrintJobExecutor {

    State state;

    @Override
    protected void doAccessControl() {
    }


    @Override
    protected void doAuthentication(EncrptPass pass, SecurityContext ctx) {
        try{
            if(AuthenticatorUser.AunthenticateUser(ctx,pass)){
                ctx.login(pass);
                state = ctx.getState();
            }
            else {
                throw new RuntimeException("Invalid Login");
            }
        }
        catch(Exception ex){
            throw ex;
        }
    }

    @Override
    protected void doPrint(Command job) {
        if((state instanceof SingletonLoggedIn)) {
           job.execute();
        }
    }

    @Override
    protected void doErrorHandling() {
        System.out.println("Authentication failed");
    }
}

