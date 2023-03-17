package edu.umb.cs680.hw5;

import edu.umb.cs680.hw4.EncrptPass;
import edu.umb.cs680.hw4.SecurityContext;
import edu.umb.cs680.hw4.User;
import edu.umb.cs680.hw5.Printer.PrintJobExecutor;

public class Main {
    public static void main(String[] args) {

        PrintJobExecutor modelNoAuth = new edu.umb.cs680.hw5.ModelNoAuth.PrintJobExecutor();
        PrintJobExecutor modelAuth = new edu.umb.cs680.hw5.ModelAuth.PrintJobExecutor();

        PrintJob job = new PrintJob();
        User user = null;
        EncrptPass pass = new EncrptPass("xyz");
        SecurityContext ctx = new SecurityContext(user);

        //this will take null password and print as authentication is skipped
        modelNoAuth.execute(job,null,ctx);
        //password is given ,exectues as expected
        modelAuth.execute(job,pass,ctx);
        //this will not take null password and throws runtime exceptiom
        modelAuth.execute(job,null,ctx);

    }

}

