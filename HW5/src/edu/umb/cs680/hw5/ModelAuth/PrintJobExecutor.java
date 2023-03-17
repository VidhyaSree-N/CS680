package edu.umb.cs680.hw5.ModelAuth;

import edu.umb.cs680.hw4.*;

public class PrintJobExecutor extends edu.umb.cs680.hw5.Printer.PrintJobExecutor {

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
    protected void doPrint() {
        if((state instanceof SingletonLoggedIn)) {
            System.out.println("Print Successful with authentication");
        }
    }

    @Override
    protected void doErrorHandling() {
        System.out.println("Authentication failed");
    }
}

