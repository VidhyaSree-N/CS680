package edu.umb.cs680.hw9.ModelAuth;

import edu.umb.cs680.hw9.*;
import edu.umb.cs680.hw9.PrintingFramework.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ModelAuthTest {

    @Test
    public void executeTest(){
       PrintJobExecutor modelAuth = new edu.umb.cs680.hw9.ModelAuth.PrintJobExecutor();
        Command job = new PrintJob();
        User user = null;
        EncrptPass pass = new EncrptPass("xyz");
        SecurityContext ctx = new SecurityContext(user);

        modelAuth.execute(job,pass,ctx);
        assertNotNull(modelAuth);
    }

    @Test
    public void doAccessControlTest(){
        PrintJobExecutor modelAuth = new edu.umb.cs680.hw9.ModelAuth.PrintJobExecutor();
        modelAuth.doAccessControl();
        assertNotNull(modelAuth);
    }

    @Test
    public void doAuthenticationTest() {
        PrintJobExecutor modelAuth = new edu.umb.cs680.hw9.ModelAuth.PrintJobExecutor();
        SecurityContext ctx = new SecurityContext(null);
        EncrptPass pass = new EncrptPass("abc");
        modelAuth.doAuthentication(pass,ctx);
        assertFalse(ctx.getState() instanceof SingletonLoggedIn);
    }

    @Test
    public void doAuthenticationNegativeTest() {
        PrintJobExecutor modelAuth = new edu.umb.cs680.hw9.ModelAuth.PrintJobExecutor();
        SecurityContext ctx = new SecurityContext(null);
        // Testing Negative case by passing null password
        try {
            modelAuth.doAuthentication(null,ctx);
        } catch (Exception ex) {
            assertTrue(ex instanceof RuntimeException);
            assertEquals("Invalid Login",ex.getMessage());
        }
    }

    //Only prints if authentication is done
    @Test
    public void doPrintTest() {
        PrintJobExecutor modelAuth = new edu.umb.cs680.hw9.ModelAuth.PrintJobExecutor();
        SecurityContext ctx = new SecurityContext(null);
        EncrptPass pass = new EncrptPass("abc");
        Command job = new PrintJob();
        modelAuth.doAuthentication(pass,ctx);
        modelAuth.doPrint(job);
        assertFalse(ctx.getState() instanceof SingletonLoggedIn);
    }

    //Doesn't print if authentication is not done
    @Test
    public void doPrintTestFail() {
        PrintJobExecutor modelAuth = new edu.umb.cs680.hw9.ModelAuth.PrintJobExecutor();
        SecurityContext ctx = new SecurityContext(null);
        Command job =new PrintJob();
        modelAuth.doPrint(job);
        assertTrue(ctx.getState() instanceof SingletonLoggedOut);
    }

    @Test
    public void doErrorHandling(){
        PrintJobExecutor modelAuth = new edu.umb.cs680.hw9.ModelAuth.PrintJobExecutor();
        assertDoesNotThrow(() -> modelAuth.doErrorHandling());
    }
}
