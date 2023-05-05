package edu.umb.cs680.hw9;

import edu.umb.cs680.hw9.ModelAuth.PrintJob;
import edu.umb.cs680.hw9.PrintingFramework.Command;
import edu.umb.cs680.hw9.PrintingFramework.PrintJobExecutor;

public class Main {
    public static void main(String[] args) {

        PrintJobExecutor modelAuth = new edu.umb.cs680.hw9.ModelAuth.PrintJobExecutor();

        Command job = new PrintJob();
        User user = null;
        EncrptPass pass = new EncrptPass("xyz");
        SecurityContext ctx = new SecurityContext(user);

        modelAuth.execute(job,pass,ctx);


    }

}

