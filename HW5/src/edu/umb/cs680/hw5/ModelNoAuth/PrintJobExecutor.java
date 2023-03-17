package edu.umb.cs680.hw5.ModelNoAuth;

import edu.umb.cs680.hw4.EncrptPass;
import edu.umb.cs680.hw4.SecurityContext;

public class PrintJobExecutor extends edu.umb.cs680.hw5.Printer.PrintJobExecutor {

    @Override
    protected void doAccessControl() {

    }

    @Override
    protected void doAuthentication(EncrptPass pass, SecurityContext ctx) {

    }

    @Override
    protected void doPrint() {
        System.out.println("Print successful without authentication");
    }

    @Override
    protected void doErrorHandling() {
    }
}